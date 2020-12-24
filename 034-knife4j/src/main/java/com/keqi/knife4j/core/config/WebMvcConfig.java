package com.keqi.knife4j.core.config;

import com.keqi.knife4j.core.pojo.CommonConstant;
import com.keqi.knife4j.core.util.CommonUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
                // 放行 knife4j 路径
                .excludePathPatterns(knife4jPaths)
                // 放行登录接口请求路径
                .excludePathPatterns("/sys/auth/login")
                // 放行公开文件请求路径
                .excludePathPatterns("/publicFile/**");
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

    /**
     * 添加静态资源映射路径（不会响应到默认的 4 个静态资源映射）
     *
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置对外公开的文件映射路径
        String filePath = "file:" + CommonUtil.getApplicationHomeAbsolutePath() + CommonConstant.UPLOAD_FILE_PUBLIC_FILE;
        registry.addResourceHandler("/publicFile/**").addResourceLocations(filePath);
    }
}

