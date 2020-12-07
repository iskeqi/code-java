package com.keqi.knife4j.core.interceptor;

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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        /*String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();

        // 通过 header 中的 accessToken 属性来获取当前登录用户信息
        String accessToken = request.getHeader(CommonConstant.ACCESS_TOKEN);
        LoginUserBO loginUserBO = JWTUtil.resolveToken(accessToken);
        if (loginUserBO != null) {
            // 设置当前操作用户信息到当前线程对象中
            Auth.setLoginUserBO(loginUserBO);
            return true;
        } else {
            throw new BusinessException("当前操作用户未登录");
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /*Auth.setLoginUserBO(null);*/
    }
}
