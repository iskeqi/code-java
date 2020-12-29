package com.keqi.knife4j.sys.aspect;

import com.keqi.knife4j.core.auth.Auth;
import com.keqi.knife4j.core.auth.LoginUserBO;
import com.keqi.knife4j.core.util.CommonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
	@Pointcut("@annotation(com.keqi.knife4j.sys.aspect.Permiss)")
	public void aspect() {
	}

	/**
	 * 验证当前操作用户是否有操作此接口的权限
	 *
	 * @param joinPoint joinPoint
	 */
	@Before("aspect()")
	public void before(JoinPoint joinPoint) {
		Permiss permiss = CommonUtil.getAnnotation(joinPoint, Permiss.class);

		// 从loginUserBO 对象中取出当前登录用户拥有的权限列表，判断是否全部满足 permiss 注解中指定的权限列表
		// 满足则通过，不满足则直接抛异常，以中断当前请求
		// throw new BusinessException("无操作权限");
		String[] permissions = permiss.value();
		LoginUserBO loginUserBO = Auth.getLoginUserBO();
	}
}
