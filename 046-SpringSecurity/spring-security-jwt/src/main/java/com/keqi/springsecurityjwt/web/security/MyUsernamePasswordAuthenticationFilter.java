package com.keqi.springsecurityjwt.web.security;

import com.keqi.springsecurityjwt.core.exception.BusinessException;
import com.keqi.springsecurityjwt.core.util.JsonUtil;
import com.keqi.springsecurityjwt.sys.domain.param.LoginParam;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义 UsernamePasswordAuthenticationFilter 过滤器
 */
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        ServletInputStream inputStream;
        try {
            inputStream = request.getInputStream();
        } catch (IOException e) {
            throw new BusinessException("参数错误");
        }
        LoginParam loginParam = JsonUtil.readValue(inputStream, LoginParam.class);
        loginParam = loginParam == null ? new LoginParam() : loginParam;
        // 用于登录成功时的后续处理
        request.setAttribute("LOGIN_PARAM_ENTITY", loginParam);

        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(loginParam.getUsername(), loginParam.getPassword());
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
