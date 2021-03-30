package com.keqi.springwebsocket.config;

import com.keqi.springwebsocket.interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web mvc 配置类
 *
 * @author keqi
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private SecurityInterceptor securityInterceptor;

	/**
	 * 注册拦截器对象
	 *
	 * @param registry registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(securityInterceptor).addPathPatterns("/**");
	}
}

