package com.keqi.iotplatform.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web mvc 配置类
 * @author keqi
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	private final HandlerInterceptor securityInterceptor;

	public WebMvcConfig(@Qualifier("securityInterceptor") HandlerInterceptor securityInterceptor) {
		this.securityInterceptor = securityInterceptor;
	}

	/**
	 * 注册拦截器对象
	 * @param registry registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册一个安全拦截器，拦截除"/auth/authentication"之外的所有请求
		registry.addInterceptor(securityInterceptor).addPathPatterns("/**").excludePathPatterns("/auth/authentication");
	}
}

