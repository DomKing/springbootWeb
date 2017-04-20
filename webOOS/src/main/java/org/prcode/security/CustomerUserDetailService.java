package org.prcode.security;

import org.prcode.business.support.basic.security.domain.CustomerUserDetail;
import org.prcode.business.support.basic.security.service.ISecurityService;
import org.prcode.business.support.basic.security.util.SecurityUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: CustomerUserDetailService
 * @Date: 2017-4-16 15:26
 * @Auther: kangduo
 * @Description: ()
 */
@Component
public class CustomerUserDetailService implements UserDetailsService {

    @Resource
    private ISecurityService securityService;

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Byte accountType = Byte.valueOf(request.getParameter(SecurityUtil.ACCOUNT_TYPE));
        CustomerUserDetail customerUserDetail = securityService.getUserDetailByName(name, accountType);
        if (customerUserDetail == null) {
            throw new UsernameNotFoundException("用户不存在或密码错误");
        }
        return customerUserDetail;
    }
}
