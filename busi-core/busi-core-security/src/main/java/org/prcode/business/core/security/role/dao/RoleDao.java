package org.prcode.business.core.security.role.dao;

import org.apache.ibatis.annotations.Param;
import org.prcode.business.core.security.role.entity.RoleEntity;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: RoleDao
 * @Date: 2017-4-22 15:01
 * @Auther: kangduo
 * @Description: ()
 */
@Repository
public interface RoleDao {
    RoleEntity getRoleEntity(@Param("roleId") String roleId, @Param("systemCode") String systemCode);
}
