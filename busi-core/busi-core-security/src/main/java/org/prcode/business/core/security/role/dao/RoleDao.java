package org.prcode.business.core.security.role.dao;

import org.apache.ibatis.annotations.Param;
import org.prcode.business.core.security.role.entity.RoleEntity;
import org.springframework.stereotype.Repository;

/**
 * @className: RoleDao
 * @date: 2017-4-22 15:01
 * @author: kangduo
 * @description: ()
 */
@Repository
public interface RoleDao {
    RoleEntity getRoleEntity(@Param("roleId") String roleId, @Param("systemCode") String systemCode);
}
