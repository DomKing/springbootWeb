package org.prcode.business.support.basic.messageConverter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: CacheDuration
 * @date: 2017-04-18 15:54
 * @author: kangduo
 * @description: (配合Cacheable注解设置redis过期时间)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface CacheDuration {
    long expireSeconds() default 5 * 60;
}
