package org.prcode.utility.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: Create
 * @date: 2017-03-24 13:20
 * @author: kangduo
 * @description: (使用此注解,根据返回值验证是否添加成功)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Insert {
    String value() default "";
}
