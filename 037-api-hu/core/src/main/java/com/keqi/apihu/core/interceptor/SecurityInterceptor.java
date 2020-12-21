package com.keqi.apihu.core.interceptor;

import com.keqi.apihu.core.auth.Auth;
import com.keqi.apihu.core.auth.LoginUserBO;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.core.pojo.CommonConstant;
import com.keqi.apihu.core.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
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
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();

        String projectIdStr = request.getHeader(CommonConstant.PROJECT_ID);
        if (requestURI.startsWith(contextPath + "/pj/")) {
            // 设置当前请求操作的项目ID（如果 URI 是以 /contextPath/pj/ 开头的，那么必须要包含 projectId）
            if (StringUtils.isEmpty(projectIdStr)) {
                throw new BusinessException("非法操作");
            }
        }

        // 通过 header 中的 accessToken 属性来获取当前登录用户信息
        String accessToken = request.getHeader(CommonConstant.ACCESS_TOKEN);
        LoginUserBO loginUserBO = JwtUtil.resolveToken(accessToken);
        if (loginUserBO != null) {
            loginUserBO.setProjectId(StringUtils.isEmpty(projectIdStr) ? null : Long.valueOf(projectIdStr));
            // 设置当前操作用户信息到当前线程对象中
            Auth.setLoginUserBO(loginUserBO);
            return true;
        } else {
            throw new BusinessException("当前操作用户未登录");
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Auth.setLoginUserBO(null);
    }
}
