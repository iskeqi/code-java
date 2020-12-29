package com.keqi.knife4j.core.aspect;

import com.keqi.knife4j.core.auth.Auth;
import com.keqi.knife4j.core.auth.LoginUserBO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * `@RequiresPermissions` 注解切面类
 *
 * @author keqi
 */
@Aspect
@Component
public class PermissAspect {

	/**
	 * 配置织入点
	 */
	@Pointcut("@annotation(com.keqi.knife4j.core.aspect.Permiss)")
	public void aspect() {
	}

	/**
	 * 验证当前操作用户是否有操作此接口的权限
	 *
	 * @param joinPoint joinPoint
	 */
	@Before("aspect()")
	public void before(JoinPoint joinPoint) {
		// 通过 JoinPoint 对象获取到方法上的注解及其属性
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		Permiss permiss = method.getAnnotation(Permiss.class);
		String[] permissions = permiss.value();

		LoginUserBO loginUserBO = Auth.getLoginUserBO();
		// 从loginUserBO 对象中取出当前登录用户拥有的权限列表，判断是否全部满足 permissions 中的权限列表
		// 满足则通过，不满足则直接抛异常，以中断当前请求
		// throw new BusinessException("无操作权限");
	}
}
