package com.keqi.seed.sys.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.keqi.seed.core.response.ResultEntity;
import com.keqi.seed.sys.domain.dto.AuthDto;
import com.keqi.seed.sys.domain.param.AuthParam;
import com.keqi.seed.sys.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResultEntity<AuthDto> auth(@RequestBody AuthParam param) {
//        return authService.auth(param);
        return null;
    }

    @DeleteMapping("/logout")
    public void logout(@RequestHeader("token") String tokenValue) {
        StpUtil.logoutByTokenValue(tokenValue);
    }
}
