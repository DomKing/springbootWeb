package org.prcode.utility.exception;

/**
 * @ClassName: ValidateException
 * @Date: 2017-03-24 13:32
 * @Auther: kangduo
 * @Description: (校验异常, 入参不合法)
 */
public class ValidateException extends Exception {

    private static final long serialVersionUID = 2352667757409387226L;

    public ValidateException() {
        super();
    }

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }
}
