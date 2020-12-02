package com.keqi.bestpracticeone.core.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web mvc 配置类
 *
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
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册一个安全拦截器，拦截所有请求（登录接口及 knife4j 的UI界面接口除外）
        String[] knife4jPaths = new String[]{
                "/doc.html",
                "/webjars/**",
                "/swagger-resources/**",
                "/swagger-ui.html/**",
                "/v2/**",
                "/favicon.ico",
                "/error"
        };

        registry.addInterceptor(securityInterceptor).addPathPatterns("/**")
                .excludePathPatterns(knife4jPaths)
                .excludePathPatterns("/sys/auth/login");
    }

    /**
     * 跨域配置
     *
     * @param registry registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}

