package com.qjzh.idomp.zjc.interceptor;

import com.qjzh.idomp.zjc.core.CommonConstants;
import com.qjzh.idomp.zjc.core.common.LoginUserBO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 安全拦截器(进行accessToken的鉴权等)
 * @author keqi
 */
@Component("securityInterceptor")
public class SecurityInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) {

		// 在此处进行鉴权,并且将登陆用户信息放到request对象中
		LoginUserBO loginUserBO = new LoginUserBO();
		loginUserBO.setLoginName("admin" + Math.random());
		request.setAttribute(CommonConstants.LOGIN_USER, loginUserBO);
		return true;
	}
}
