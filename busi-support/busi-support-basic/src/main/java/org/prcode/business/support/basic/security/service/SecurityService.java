package org.prcode.business.support.basic.security.service;

import org.prcode.business.basedomain.role.domain.Role;
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

    public CustomerUserDetail getUserDetailByName(String username, Byte accountType) {
        return securityDao.getUserDetailByName(username, accountType);
    }

    @Cacheable(value = "busiSupport:securityService:userRoles", key = "#p0 + '_' +#p1")
    @CacheDuration
    public List<Role> getUserRoleList(String username, Byte accountType) {
        CustomerUserDetail userDetail = securityDao.getUserDetailByName(username, accountType);
        return userDetail == null ? null : userDetail.getRoles();
    }

    public List<CustomerUrlRoles> getUrlRoles(String systemCode) {
        return securityDao.getUrlRoles(systemCode);
    }
}
