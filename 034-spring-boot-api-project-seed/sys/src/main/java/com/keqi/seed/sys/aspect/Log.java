package com.keqi.seed.sys.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用在 Controller 的方法上，表示调用此次接口会记录请求日志到DB中
 *
 * @author keqi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

	String value();
}
