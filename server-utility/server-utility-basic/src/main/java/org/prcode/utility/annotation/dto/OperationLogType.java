package org.prcode.utility.annotation.dto;

/**
 * @ClassName: OperationLogType
 * @Date: 2017-03-24 13:15
 * @Auther: kangduo
 * @Description: (操作类型判断)
 */
public enum OperationLogType {
    /**
     * 操作查询，日志不插入数据库
     */
    SELECT(0),

    /**
     * 操作插入，日志记录数据库
     */

    INSERT(1),

    /**
     * 操作更新，日志记录数据库
     */
    UPDATE(2),

    /**
     * 操作删除，日志记录数据库
     */
    DELETE(3);

    private int index;

    OperationLogType(int idx) {
        this.index = idx;
    }

    public int getIndex() {
        return index;
    }
}
