package org.prcode.business.support.basic.security.config;

import org.prcode.business.basedomain.resourceUrl.dao.ResourceUrlMapper;
import org.prcode.business.basedomain.resourceUrl.domain.ResourceUrl;
import org.prcode.business.basedomain.resourceUrl.domain.ResourceUrlExample;
import org.prcode.business.support.basic.SystemConstant;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @ClassName: CsrfSecurityRequestMatcher
 * @Date: 2017-4-16 19:53
 * @Auther: kangduo
 * @Description: (csrf)
 */
@Component
public class CsrfSecurityRequestMatcher implements RequestMatcher {

    @Resource
    private ResourceUrlMapper resourceUrlMapper;
    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

    @Override
    public boolean matches(HttpServletRequest request) {
        List<String> includeUrls = getIncludeUrls();
        if (includeUrls != null && includeUrls.size() > 0) {
            String servletPath = request.getServletPath();
            for (String url : includeUrls) {
                if (servletPath.contains(url)) {
                    return !allowedMethods.matcher(request.getMethod()).matches();
                }
            }
        }
        return false;
    }

    private List<String> getIncludeUrls() {
        List<String> includeUrls = null;
        //查询需要csrf校验的链接，并添加
        ResourceUrlExample example = new ResourceUrlExample();
        example.createCriteria()
                .andSysDelStateEqualTo(false)
                .andNeedCsrfEqualTo(true).andSystemCodeEqualTo(SystemConstant.OOS_SYSTEM);
        List<ResourceUrl> resourceUrls = resourceUrlMapper.selectByExample(example);
        if (resourceUrls != null && resourceUrls.size() > 0) {
            includeUrls = new ArrayList<>(resourceUrls.size());
            for (ResourceUrl resourceUrl : resourceUrls) {
                includeUrls.add(resourceUrl.getUrl());
            }
        }
        return includeUrls;
    }
}
