package com.keqi.knife4j.core.aspect;

import com.keqi.knife4j.core.auth.Auth;
import com.keqi.knife4j.core.auth.LoginUserBO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * `@Log` 注解切面类
 *
 * @author keqi
 */
@Aspect
@Component
public class LogAspect {

	/**
	 * 配置织入点
	 */
	@Pointcut("@annotation(com.keqi.knife4j.core.aspect.Log)")
	public void aspect() {
	}

	/**
	 * 记录此次 HTTP 请求的请求参数/响应参数等，并记录日志到 DB 中
	 *
	 * @param joinPoint joinPoint
	 */
	@After("aspect()")
	public void after(JoinPoint joinPoint) {
		// 通过 JoinPoint 对象获取到方法上的注解及其属性
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		Log log = method.getAnnotation(Log.class);
		// 根据实际需要设计日志操作记录表，并入库

		LoginUserBO loginUserBO = Auth.getLoginUserBO();
		// 记录此次操作日志（开启一个新线程，执行入库操作）
	}
}
