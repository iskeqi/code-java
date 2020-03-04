package com.qjzh.idomp.zjc.core.interceptor;

import com.alibaba.fastjson.JSON;
import com.qjzh.idomp.zjc.core.CommonConstants;
import com.qjzh.idomp.zjc.core.common.AjaxEntityBuilder;
import com.qjzh.idomp.zjc.core.common.LoginUserBO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 安全拦截器(进行accessToken的鉴权等)
 * @author keqi
 */
@Component("securityInterceptor")
public class SecurityInterceptor implements HandlerInterceptor {

	@Value("${spring.profiles.active}")
	private String profile;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException {

		// 1、调用SSO进行登录认证
		LoginUserBO loginUserBO = this.authentication(request.getHeader(CommonConstants.ACCESS_TOKEN));
		if (loginUserBO == null) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(JSON.toJSONString(AjaxEntityBuilder.noAuth()));
			return false;
		}

		// 2、鉴权成功后，将登陆用户信息放到当前线程绑定的request对象中
		request.setAttribute(CommonConstants.LOGIN_USER, loginUserBO);
		return true;
	}

	/**
	 * 身份认证
	 * @param accessToken accessToken
	 * @return r
	 */
	private LoginUserBO authentication(String accessToken) {
		// 开发环境不进行认证
		if ("dev".equals(profile)) {
			LoginUserBO loginUserBO = new LoginUserBO();
			loginUserBO.setLoginName("admin");
			loginUserBO.setName("超级管理员");
			return loginUserBO;
		}
		if (accessToken != null) {
			// 调用SSO服务器进行身份认证，根据调用结果决定返回值
			// todo
			return null;
		}
		return null;
	}
}
