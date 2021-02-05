package com.keqi.seed.sys.aspect;

import com.keqi.seed.core.web.exception.BusinessException;
import com.keqi.seed.sys.mapper.AccountMapper;
import com.keqi.seed.sys.pojo.Auth;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

/**
 * `@RequiresPermissions` 注解切面类
 *
 * @author keqi
 */
@Aspect
@Component
public class PermissAspect {

	@Autowired
	private AccountMapper accountMapper;

	/**
	 * 配置织入点
	 */
	@Pointcut("@annotation(com.keqi.seed.sys.aspect.Permiss)")
	public void aspect() {
	}

	/**
	 * 验证当前操作用户是否有操作此接口的权限
	 *
	 * @param joinPoint joinPoint
	 */
	@Before("aspect()")
	public void before(JoinPoint joinPoint) {
		// 从loginUserBO 对象中取出当前登录用户拥有的权限列表，判断是否全部满足 permiss 注解中指定的权限列表
		// 满足则通过，不满足则直接抛异常，以中断当前请求
		// throw new BusinessException("您无此操作权限");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		Permiss permiss = method.getAnnotation(Permiss.class);
		String[] permissList = permiss.value();

		List<String> loginAccountPermissList = Auth.getPermissList();

		boolean flag = false;
		for (String permissStr : permissList) {
			flag = false;
			for (String t : loginAccountPermissList) {
				if (permissStr.equals(t)) {
					flag = true;
					break;
				}
			}
		}
		if (!flag) {
			throw new BusinessException("您无此操作权限");
		}
	}
}
