package com.keqi.springsecurityjwt.web.security;

import com.keqi.springsecurityjwt.core.response.ResultEntity;
import com.keqi.springsecurityjwt.core.response.ResultEntityBuilder;
import com.keqi.springsecurityjwt.core.util.JsonUtil;
import com.keqi.springsecurityjwt.core.util.JwtUtil;
import com.keqi.springsecurityjwt.sys.pojo.Auth;
import com.keqi.springsecurityjwt.sys.pojo.LoginUserBO;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * token 处理过滤器
 */
public class TokenFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String jwtToken = req.getHeader("token");

        LoginUserBO loginUserBO = JwtUtil.resolveToken(jwtToken, LoginUserBO.class);
        if (loginUserBO == null) {

            ResultEntity resultEntity = ResultEntityBuilder.noAuth("未登录异常");
            String json = JsonUtil.writeValueAsString(resultEntity);

            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.write(json);
            out.flush();
            out.close();
            return;
        }


        Auth.setLoginUserBO(loginUserBO);

        filterChain.doFilter(req, servletResponse);

        Auth.setLoginUserBO(null);
    }
}
