package org.prcode.business.support.basic.validate;

import org.prcode.utility.util.StringUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className: ValidateRegexpValidator
 * @date: 2017-4-21 22:22
 * @author: kangduo
 * @description: (jsr正则校验)
 */
public class ValidateRegexpValidator implements ConstraintValidator<ValidateRegexp, Object> {

    private ValidateRegexp validateRegexp;

    @Override
    public void initialize(final ValidateRegexp constraintAnnotation) {
        this.validateRegexp = constraintAnnotation;
    }

    @Override
    public boolean isValid(final Object value, ConstraintValidatorContext context) {
        if (value == null || "".equals(value)) {
            return true;
        } else if (!StringUtil.isEmpty(validateRegexp.regexp())) {
            Pattern pattern = Pattern.compile(validateRegexp.regexp());
            Matcher matcher = pattern.matcher(value.toString().replaceAll("/", ""));
            return matcher.matches();
        }
        return false;
    }

}
