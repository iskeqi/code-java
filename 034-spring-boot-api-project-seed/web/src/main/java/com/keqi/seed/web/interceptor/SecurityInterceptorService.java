package com.keqi.seed.web.interceptor;

import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证拦截器接口
 *
 * 子类需实现此接口中的方法实现认证拦截功能
 *
 * @author keqi
 */
public interface SecurityInterceptorService {

    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler);

    void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex);
}
