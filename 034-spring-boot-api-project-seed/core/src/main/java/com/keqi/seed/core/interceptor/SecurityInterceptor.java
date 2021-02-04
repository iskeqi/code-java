package com.keqi.seed.core.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 安全拦截器(进行token的鉴权等)
 *
 * @author keqi
 */
@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    private SecurityInterceptorService securityInterceptorService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return securityInterceptorService.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        securityInterceptorService.postHandle(request, response, handler, modelAndView);
    }
}
