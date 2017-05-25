package org.prcode.business.support.basic.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @ClassName: ValidateRegexp
 * @Date: 2017-4-21 22:21
 * @Auther: kangduo
 * @Description: (jsr正则校验)
 */
@Constraint(validatedBy = {ValidateRegexpValidator.class})
@Documented
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface ValidateRegexp {

    String message() default "校验失败";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String regexp() default "";
}
