package com.keqi.projectseedsecond.interceptor;

import com.keqi.projectseedsecond.common.Auth;
import com.keqi.projectseedsecond.common.LoginUserBO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 安全拦截器(进行accessToken的鉴权等)
 *
 * @author keqi
 */
@Component("securityInterceptor")
public class SecurityInterceptor implements HandlerInterceptor {

	@Value("${spring.profiles.active}")
	private String profile;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		LoginUserBO loginUserBO = new LoginUserBO();
		// 开发环境不进行认证
		if ("dev".equals(profile)) {
			loginUserBO.setLoginAccount("ZhangSan");
			loginUserBO.setLoginAccountName("张三");
		} else {
			// 获取token，然后进行认证
			/*

			String accessToken = request.getHeader(CommonConstant.ACCESS_TOKEN);
			if (true) {
				// 设置登录用户信息
			}
			if (false) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().write(JSON.toJSONString(AjaxEntityBuilder.noAuth()));
				return false;
			}

			*/
		}
		// 2、鉴权成功后，将登陆用户信息放到当前线程绑定的request对象中
		Auth.setLoginUserBO(loginUserBO);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		Auth.setLoginUserBO(null);
	}
}
