package org.prcode.utility.exception;

/**
 * @ClassName: BusinessException
 * @Date: 2017-03-24 13:28
 * @Auther: kangduo
 * @Description: (业务异常, 如输入数据有问题导致的查询无结果, 业务不对等)
 */
public class BusinessException extends Exception{

    private static final long serialVersionUID = 5433269823524347251L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
