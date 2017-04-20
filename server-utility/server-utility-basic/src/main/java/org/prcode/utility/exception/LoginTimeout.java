package org.prcode.utility.exception;

/**
 * @ClassName: LoginTimeout
 * @Date: 2017-04-14 17:58
 * @Auther: kangduo
 * @Description: (登录超时异常)
 */
public class LoginTimeout extends Exception {

    private static final long serialVersionUID = 1752633971985729891L;

    public LoginTimeout() {
        super();
    }

    public LoginTimeout(String message) {
        super(message);
    }

    public LoginTimeout(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginTimeout(Throwable cause) {
        super(cause);
    }
}
