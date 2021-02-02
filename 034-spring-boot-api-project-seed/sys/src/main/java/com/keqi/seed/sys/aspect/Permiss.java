package com.keqi.seed.sys.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用在 Controller 的方法上，声明调用此接口要求的权限标识
 *
 * @author keqi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permiss {

	String[] value();
}
