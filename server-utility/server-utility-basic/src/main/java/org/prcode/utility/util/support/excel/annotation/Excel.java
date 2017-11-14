/**
 * Copyright (C) 2015 Shenzhen virgo network technology Co., Ltd. All rights reserved. 
 *
 * @date:2015年10月20日 上午11:14:22
 *
 * @Version V1.0
 */
package org.prcode.utility.util.support.excel.annotation;

import java.lang.annotation.*;


/**
 * @className: Excel
 * @date: 2017-04-24 15:47
 * @author: kangduo
 * @description: (自定义注解 excel导入导出)
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Excel {
	public String title() default "";
}
