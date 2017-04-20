package org.prcode.utility.basic.support;

/**
 * @ClassName: ResponseStatus
 * @Date: 2017-03-30 16:41
 * @Auther: kangduo
 * @Description: (响应状态代码)
 */
public class ResponseStatus {
    /**
     * 成功
     */
    public static final String SUCCESS = "0000";
    /**
     * 校验异常
     */
    public static final String VALIDATE_ERR = "0001";
    /**
     * 系统异常
     */
    public static final String SYSTEM_ERR = "0002";
    /**
     * 登录超时
     */
    public static final String LOGIN_TIME_OUT = "0003";
    /**
     * 业务处理异常
     */
    public static final String BUSINESS_FAILED = "0004";
    /**
     * 没有权限
     */
    public static final String NO_PRIVILEGE = "0005";

}
