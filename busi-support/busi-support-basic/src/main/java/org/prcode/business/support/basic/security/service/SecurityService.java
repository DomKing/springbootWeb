package org.prcode.business.support.basic.security.service;

import org.prcode.business.basedomain.resourceUrl.dao.ResourceUrlMapper;
import org.prcode.business.basedomain.resourceUrl.domain.ResourceUrl;
import org.prcode.business.basedomain.resourceUrl.domain.ResourceUrlExample;
import org.prcode.business.basedomain.role.domain.Role;
import org.prcode.business.support.basic.AccountType;
import org.prcode.business.support.basic.messageConverter.annotation.CacheDuration;
import org.prcode.business.support.basic.security.dao.SecurityDao;
import org.prcode.business.support.basic.security.domain.CustomerUrlRoles;
import org.prcode.business.support.basic.security.domain.CustomerUserDetail;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: SecurityService
 * @Date: 2017-04-18 16:16
 * @Auther: kangduo
 * @Description: (安全相关service)
 */
@Service
public class SecurityService implements ISecurityService {

    @Resource
    private SecurityDao securityDao;
    @Resource
    private ResourceUrlMapper resourceUrlMapper;

    public CustomerUserDetail getUserDetailByName(String username, Byte accountType) {
        String systemCode = AccountType.getSystemCode(accountType);
        return securityDao.getUserDetailByName(username, accountType, systemCode);
    }

    @Cacheable(value = "busiSupport:securityService:userRoles", key = "#p0 + '_' +#p1")
    @CacheDuration
    public List<Role> getUserRoleList(String username, Byte accountType) {
        String systemCode = AccountType.getSystemCode(accountType);
        CustomerUserDetail userDetail = securityDao.getUserDetailByName(username, accountType, systemCode);
        return userDetail == null ? null : userDetail.getRoles();
    }

    @Cacheable(value = "busiSupport:securityService:csrfResourceUrls", key = "#p0")
    @CacheDuration(expireSeconds = 60 * 60)
    public List<ResourceUrl> getCsrfResourceUrls(String systemCode) {
        ResourceUrlExample example = new ResourceUrlExample();
        example.createCriteria()
                .andSysDelStateEqualTo(false)
                .andNeedCsrfEqualTo(true).andSystemCodeEqualTo(systemCode);
        return resourceUrlMapper.selectByExample(example);
    }

    public List<CustomerUrlRoles> getUrlRoles(String systemCode) {
        return securityDao.getUrlRoles(systemCode);
    }
}
