package org.prcode.business.core.security.role.service;

import org.prcode.business.core.security.role.entity.RoleEntity;
import org.prcode.utility.exception.BusinessException;

/**
 * @className: IRoleService
 * @date: 2017-4-22 15:12
 * @author: kangduo
 * @description: ()
 */
public interface RoleService {
    Integer addRole(RoleEntity entity) throws BusinessException;

    RoleEntity getRoleEntity(String roleId, String systemCode);

    Integer updRole(RoleEntity entity);
}
