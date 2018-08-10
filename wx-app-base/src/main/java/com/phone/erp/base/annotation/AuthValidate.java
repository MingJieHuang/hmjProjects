package com.phone.erp.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * [标记在controller方法上,用于进行权限验证]
 *
 * @author Chris li
 * @version [版本, 2017-4-12]
 * @see
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthValidate {
}
