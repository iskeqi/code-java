package com.keqi.springsecurityjwt.web.security;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.springsecurityjwt.core.response.ResultEntityBuilder;
import com.keqi.springsecurityjwt.core.util.JsonUtil;
import com.keqi.springsecurityjwt.core.util.JwtUtil;
import com.keqi.springsecurityjwt.sys.domain.param.LoginParam;
import com.keqi.springsecurityjwt.sys.pojo.LoginUserBO;
import com.keqi.springsecurityjwt.sys.domain.vo.LoginVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 认证成功处理类
 */
public class MyLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // 如果有额外参数，建议从这里获取，并做额外处理，比如 devType 等
        LoginParam loginParam = (LoginParam) request.getAttribute("LOGIN_PARAM_ENTITY");

        LoginUserBO principal = (LoginUserBO) authentication.getPrincipal();
        principal.setDevType(loginParam.getDevType());

        String token = JwtUtil.generateToken(BeanUtil.beanToMap(principal), new Date(System.currentTimeMillis() + 3600000));
        String json = JsonUtil.writeValueAsString(ResultEntityBuilder.success(new LoginVO(token)));

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(json);
        out.flush();
        out.close();
    }
}
