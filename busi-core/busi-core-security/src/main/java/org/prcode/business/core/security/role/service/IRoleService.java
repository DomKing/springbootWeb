package org.prcode.business.core.security.role.service;

import org.prcode.business.core.security.role.entity.RoleEntity;
import org.prcode.utility.exception.BusinessException;

/**
 * @ClassName: IRoleService
 * @Date: 2017-4-22 15:12
 * @Auther: kangduo
 * @Description: ()
 */
public interface IRoleService {
    Integer addRole(RoleEntity entity) throws BusinessException;

    RoleEntity getRoleEntity(String roleId, String systemCode);

    Integer updRole(RoleEntity entity);
}
