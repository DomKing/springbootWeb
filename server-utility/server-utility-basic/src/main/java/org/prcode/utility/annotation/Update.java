package org.prcode.utility.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: Update
 * @Date: 2017-03-24 13:21
 * @Auther: kangduo
 * @Description: (使用此注解,根据结果判断是否更新成功)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Update {
    String value() default "";
}
