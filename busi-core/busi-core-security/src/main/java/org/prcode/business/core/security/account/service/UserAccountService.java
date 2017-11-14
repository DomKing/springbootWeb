package org.prcode.business.core.security.account.service;

import org.prcode.business.core.security.account.entity.UserAccount;
import org.prcode.utility.exception.BusinessException;

import java.util.List;

/**
 * @className: IUserAccountService
 * @date: 2017-4-19 22:08
 * @author: kangduo
 * @description: ()
 */
public interface UserAccountService {
    List<UserAccount> getUserAccountList(UserAccount account, Byte accountType);

    UserAccount getUserAccount(String userId, Byte accountType);

    Integer addAccount(UserAccount userAccount, byte accountType) throws BusinessException;

    Integer updAccount(UserAccount account);
}
