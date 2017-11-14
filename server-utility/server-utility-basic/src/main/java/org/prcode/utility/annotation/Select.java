package org.prcode.utility.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: Query
 * @date: 2017-03-24 13:23
 * @author: kangduo
 * @description: (使用此注解,根据结果判断是否有符合条件的记录)
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Select {
    String value() default "";
}
