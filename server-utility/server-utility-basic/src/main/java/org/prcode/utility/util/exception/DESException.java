package org.prcode.utility.util.exception;

/**
 * @className: DESException
 * @date: 2017-03-24 14:30
 * @author: kangduo
 * @description: (DES相关异常)
 */
public class DESException extends Exception {
    private static final long serialVersionUID = -4753565922915738200L;

    public DESException() {
        super();
    }

    public DESException(String message) {
        super(message);
    }

    public DESException(String message, Throwable cause) {
        super(message, cause);
    }

    public DESException(Throwable cause) {
        super(cause);
    }
}
