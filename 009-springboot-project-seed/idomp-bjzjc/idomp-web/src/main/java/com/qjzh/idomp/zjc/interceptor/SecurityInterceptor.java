package com.qjzh.idomp.zjc.interceptor;

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
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
							 Object handler) throws Exception {
		// 在此处进行鉴权
		return true;
	}
}
