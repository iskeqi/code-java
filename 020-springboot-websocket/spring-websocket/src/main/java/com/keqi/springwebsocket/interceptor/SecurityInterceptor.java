package com.keqi.springwebsocket.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 安全拦截器(进行token的鉴权等)
 *
 * @author keqi
 */
@Slf4j
@Component
public class SecurityInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		log.info("SecurityInterceptor.preHandle() 方法");
		// 可见 SpringMVC 的拦截器是无法拦截 websocket请求的，即便是握手阶段也不会拦截
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
	}
}
