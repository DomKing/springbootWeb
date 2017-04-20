package org.prcode.utility.exception;

/**
 * @ClassName: NoPrivilegeException
 * @Date: 2017-04-14 17:57
 * @Auther: kangduo
 * @Description: (无权限异常)
 */
public class NoPrivilegeException extends Exception{

    private static final long serialVersionUID = -1150060851781201693L;

    public NoPrivilegeException() {
        super();
    }

    public NoPrivilegeException(String message) {
        super(message);
    }

    public NoPrivilegeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPrivilegeException(Throwable cause) {
        super(cause);
    }
}
