package org.prcode.business.support.basic.security.config;

import org.prcode.business.basedomain.role.domain.Role;
import org.prcode.business.support.basic.security.domain.CustomerUserDetail;
import org.prcode.business.support.basic.security.service.ISecurityService;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName: CustomerAccessDecisionManager
 * @Date: 2017-4-16 20:17
 * @Auther: kangduo
 * @Description: (权限管理决断器)
 */
public class CustomerAccessDecisionManager implements AccessDecisionManager {

    private ISecurityService securityService;

    public CustomerAccessDecisionManager(ISecurityService securityService) {
        super();
        this.securityService = securityService;
    }

    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection)
            throws AccessDeniedException, InsufficientAuthenticationException {
        if (collection == null) {
            return;
        }
        String needRole;
        //遍历需要的角色，如果一样，则通过，避免角色信息变了，从数据库取
        CustomerUserDetail userDetail = (CustomerUserDetail) authentication.getPrincipal();
        List<Role> roleList = securityService.getUserRoleList(userDetail.getUsername(), userDetail.getAccountType());
        for (ConfigAttribute configAttribute : collection) {
            needRole = configAttribute.getAttribute();
            for (Role aRoleList : roleList) {
                if (aRoleList != null && needRole.equals(aRoleList.getRoleCode())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("Cannot Access!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
