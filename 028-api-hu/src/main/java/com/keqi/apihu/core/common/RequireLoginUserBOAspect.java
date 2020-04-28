package com.keqi.apihu.core.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RequireLoginUserBOAspect {

	@Before("@annotation(RequireLoginUserBO)")
	public void injectTheCurrentlyLoginUserInformation(JoinPoint point) throws Throwable {
		// 注入当前线程中保存的登录对象，需要通过反射的方式判断是否存在固定属性loginUserBO
	}
}
