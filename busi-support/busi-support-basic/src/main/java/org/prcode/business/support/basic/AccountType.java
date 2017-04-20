package org.prcode.business.support.basic;

/**
 * @ClassName: AccountType
 * @Date: 2017-4-19 22:32
 * @Auther: kangduo
 * @Description: (账号类型)
 */
public class AccountType {
    public static final byte LP_MOBILE = 1;
    public static final byte LP_WECHAT = 2;
    public static final byte LP_WEIBO = 3;
    public static final byte OOS = 4;

    public static String getSystemCode(Byte accountType) {
        if (accountType == LP_MOBILE || accountType == LP_WECHAT || accountType == LP_WEIBO) {
            return SystemConstant.LITTLE_PROGRAME;
        } else if (accountType == OOS) {
            return SystemConstant.OOS_SYSTEM;
        }
        return null;
    }
}
