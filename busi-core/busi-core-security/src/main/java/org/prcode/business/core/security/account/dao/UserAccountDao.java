package org.prcode.business.core.security.account.dao;

import org.apache.ibatis.annotations.Param;
import org.prcode.business.core.security.account.entity.UserAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: UserAccountDao
 * @Date: 2017-4-19 22:08
 * @Auther: kangduo
 * @Description: ()
 */
@Repository
public interface UserAccountDao {
    List<UserAccount> getUserAccountList(@Param("account") UserAccount account,
                                         @Param("systemCode") String systemCode,
                                         @Param("accountType") Byte accountType);

    UserAccount getUserAccount(@Param("userId") String userId,
                               @Param("systemCode") String systemCode,
                               @Param("accountType") Byte accountType);
}
