package com.keqi.apihu.core.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在方法上使用此注解，会自动给方法中的第一个或者第二个直至第n个参数的loginUserBO的属性注入LoginUserBO对象
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface RequireLoginUserBO {
}
