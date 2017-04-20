package org.prcode.business.support.basic.util;

import org.prcode.utility.exception.ValidateException;
import org.springframework.validation.BindingResult;

/**
 * @ClassName: BindingResultUtil
 * @Date: 2017-03-30 19:34
 * @Auther: kangduo
 * @Description: (校验工具类)
 */
public class BindingResultUtil {

    public static void validateResult(BindingResult result) throws ValidateException {
        if (result.getAllErrors().size() > 0) {
            throw new ValidateException(result.getAllErrors().get(0).getDefaultMessage());
        }
    }

    public static void validateResult(BindingResult result, String message) throws ValidateException {
        if (result.getAllErrors().size() > 0) {
            throw new ValidateException(message);
        }
    }
}
