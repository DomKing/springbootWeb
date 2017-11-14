package org.prcode.utility.annotation;

import org.prcode.utility.annotation.dto.OperationLogType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: Action
 * @date: 2017-03-24 13:18
 * @author: kangduo
 * @description: (用户操作日志注解类)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
    String value() default "未标注";
    OperationLogType type() default OperationLogType.SELECT;
}
