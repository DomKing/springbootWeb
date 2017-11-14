package org.prcode.business.support.basic;

/**
 * @className: AccountType
 * @date: 2017-4-19 22:32
 * @author: kangduo
 * @description: (账号类型)
 */
public class AccountType {
    public static final byte MP_MOBILE = 1;
    public static final byte MP_WECHAT = 2;
    public static final byte MP_WEIBO = 3;
    public static final byte OOS = 4;

    public static String getSystemCode(Byte accountType) {
        if (accountType == MP_MOBILE || accountType == MP_WECHAT || accountType == MP_WEIBO) {
            return SystemConstant.MINI_PROGRAM;
        } else if (accountType == OOS) {
            return SystemConstant.OOS_SYSTEM;
        }
        return null;
    }
}
