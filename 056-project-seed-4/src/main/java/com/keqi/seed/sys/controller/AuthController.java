package com.keqi.seed.sys.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.keqi.seed.sys.domain.dto.AuthDto;
import com.keqi.seed.sys.domain.param.AuthParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/auth")
public class AuthController {

    @PostMapping("/login")
    public AuthDto auth(@RequestBody AuthParam param) {
        // 进行登录认证 ...
        StpUtil.login(param.getUsername(), param.getDevice());
        return new AuthDto(StpUtil.getTokenInfo().getTokenValue());
    }

    @DeleteMapping("/logout")
    public void logout(@RequestHeader("token") String tokenValue) {
        StpUtil.logoutByTokenValue(tokenValue);
    }
}
