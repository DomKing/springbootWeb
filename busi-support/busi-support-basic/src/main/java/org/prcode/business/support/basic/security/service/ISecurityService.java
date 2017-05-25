package org.prcode.business.support.basic.security.service;

import org.prcode.business.basedomain.resourceUrl.domain.ResourceUrl;
import org.prcode.business.basedomain.role.domain.Role;
import org.prcode.business.support.basic.security.domain.CustomerUrlRoles;
import org.prcode.business.support.basic.security.domain.CustomerUserDetail;

import java.util.List;

/**
 * @ClassName: ISecurityService
 * @Date: 2017-04-18 16:16
 * @Auther: kangduo
 * @Description: (安全相关service)
 */
public interface ISecurityService {

    CustomerUserDetail getUserDetailByName(String username, Byte accountType);

    List<Role> getUserRoleList(String username, Byte accountType);

    List<ResourceUrl> getCsrfResourceUrls(String systemCode);

    List<CustomerUrlRoles> getUrlRoles(String systemCode);
}
