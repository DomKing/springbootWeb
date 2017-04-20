package org.prcode.business.support.basic.security.dao;

import org.apache.ibatis.annotations.Param;
import org.prcode.business.support.basic.security.domain.CustomerUrlRoles;
import org.prcode.business.support.basic.security.domain.CustomerUserDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: UserDao
 * @Date: 2017-4-16 15:49
 * @Auther: kangduo
 * @Description: ()
 */
@Repository
public interface SecurityDao {
    CustomerUserDetail getUserDetailByName(@Param("username") String username, @Param("accountType") Byte accountType);

    List<CustomerUrlRoles> getUrlRoles(String systemCode);
}
