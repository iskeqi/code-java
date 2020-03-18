package com.keqi.projectseedfirst.interceptor;

import com.keqi.projectseedfirst.common.LoginUserBO;
import com.keqi.projectseedfirst.enums.CommonEnum;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 当前登录用户工具类(还是改换成ThreadLocal吧)
 */
public class Auth {

	/**
	 * 获取当前线程操作用户登录名
	 *
	 * @return r
	 */
	public static String getLoginName() {
		return getLoginUserBO().getLoginName();
	}

	/**
	 * 获取当前线程操作用户姓名
	 *
	 * @return r
	 */
	public static String getName() {
		return getLoginUserBO().getName();
	}

	/**
	 * 获取当前线程操作用户信息
	 *
	 * @return r
	 */
	public static LoginUserBO getLoginUserBO() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		return (LoginUserBO) request.getAttribute(CommonEnum.LOGIN_USER.name());
	}


}
