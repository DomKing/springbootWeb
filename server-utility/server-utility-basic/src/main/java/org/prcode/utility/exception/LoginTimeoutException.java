package org.prcode.utility.exception;

/**
 * @className: LoginTimeout
 * @date: 2017-04-14 17:58
 * @author: kangduo
 * @description: (登录超时异常)
 */
public class LoginTimeoutException extends RuntimeException {

    private static final long serialVersionUID = 1752633971985729891L;

    public LoginTimeoutException() {
        super();
    }

    public LoginTimeoutException(String message) {
        super(message);
    }

    public LoginTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginTimeoutException(Throwable cause) {
        super(cause);
    }
}
