package com.qjzh.idomp.zjc.core.aop;

import cn.hutool.core.bean.BeanUtil;
import com.qjzh.idomp.zjc.core.Auth;
import com.qjzh.idomp.zjc.core.CommonConstants;
import com.qjzh.idomp.zjc.core.common.BaseEntity;
import com.qjzh.idomp.zjc.core.common.LoginUserBO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 注入登录用户到service包下的方法中
 *
 * @author keqi
 */
@Aspect
@Component
public class InjectLoginUser {

	@Pointcut("execution(public * com.qjzh.idomp.zjc..*.service..*.*(..))")
	public void injectUser(){}

	@Before("injectUser()")
	public void doBefore (JoinPoint joinPoint) {
		// 1、获取方法的参数(第一个参数、第二个参数都可以)
		Object[] args = joinPoint.getArgs();

		// 2、如果该方法无参数或者第一个参数不属于BaseEntity或者Map的子类，则直接结束
		if (args == null ||
				args.length == 0 ||
				(!(args[0] instanceof BaseEntity) && !(args[0] instanceof Map))) {
			return;
		}

		// 3、如果第一个参数是BaseEntity或者Map的子类，则将当前登录对象LoginUserBO注入到"loginUser"属性中
		LoginUserBO loginUserBO = Auth.getLoginUserBO();
		BeanUtil.setProperty(args[0], CommonConstants.LOGIN_USER, loginUserBO);
	}
}
