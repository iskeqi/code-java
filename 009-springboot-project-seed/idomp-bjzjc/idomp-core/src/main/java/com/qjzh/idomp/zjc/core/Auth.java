package com.qjzh.idomp.zjc.core;

import com.qjzh.idomp.zjc.core.common.LoginUserBO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 当前登录用户工具类
 */
public class Auth {

	/**
	 * 获取当前线程操作用户登录名
	 * @return r
	 */
	public static String getLoginName() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		LoginUserBO loginUserBO = (LoginUserBO) request.getAttribute("loginUser");
		return loginUserBO.getLoginName();
	}

	/**
	 * 获取当前线程操作用户信息
	 * @return r
	 */
	public static LoginUserBO getLoginUserBO() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		return  (LoginUserBO) request.getAttribute("loginUser");
	}


}
