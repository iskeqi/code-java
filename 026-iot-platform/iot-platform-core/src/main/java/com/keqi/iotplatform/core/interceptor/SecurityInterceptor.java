package com.keqi.iotplatform.core.interceptor;

import com.keqi.iotplatform.core.Auth;
import com.keqi.iotplatform.core.constant.CommonConstant;
import com.keqi.iotplatform.core.domain.LoginUserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
		String accessToken = request.getHeader(CommonConstant.ACCESS_TOKEN);

		if (StringUtils.isEmpty(accessToken) && "dev".equals(profile)) {
			// 开发环境，不走正常登陆逻辑(后期会删除掉此段代码)
			LoginUserBO loginUserBO = new LoginUserBO();
			loginUserBO.setLoginAccount("ZhangSan");
			loginUserBO.setLoginAccountName("张三");
			Auth.setLoginUserBO(loginUserBO);
			return true;
		}
		// 其他情况全部都要走正常登录逻辑
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
		// 2、鉴权成功后，将登陆用户信息放到当前线程绑定的request对象中

		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		Auth.setLoginUserBO(null);
	}
}
