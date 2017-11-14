package org.prcode.business.support.basic.security.dao;

import org.apache.ibatis.annotations.Param;
import org.prcode.business.support.basic.security.domain.CustomerUrlRoles;
import org.prcode.business.support.basic.security.domain.CustomerUserDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @className: UserDao
 * @date: 2017-4-16 15:49
 * @author: kangduo
 * @description: ()
 */
@Repository
public interface SecurityDao {
    CustomerUserDetail getUserDetailByName(@Param("username") String username,
                                           @Param("accountType") Byte accountType,
                                           @Param("systemCode") String systemCode);

    List<CustomerUrlRoles> getUrlRoles(String systemCode);
}
