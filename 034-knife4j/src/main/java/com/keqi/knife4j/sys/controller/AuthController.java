package com.keqi.knife4j.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.sys.domain.vo.LoginVO;
import com.keqi.knife4j.sys.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "1. 登录管理")
@ApiSupport(order = 1)
@AllArgsConstructor
@RestController
@RequestMapping("/sys/auth")
public class AuthController {

    private final AccountService accountService;

    @ApiOperation(value = "1.1 登录")
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", example = "admin", required = true),
            @ApiImplicitParam(name = "password", value = "密码", example = "123456", required = true)
    })
    @PostMapping("/login")
    public LoginVO login(@RequestParam String account, @RequestParam String password) {
        return this.accountService.login(account, password);
    }

    @ApiOperation(value = "1.2 修改密码")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "password", value = "原密码", example = "123456", required = true),
            @ApiImplicitParam(name = "newPassword", value = "新密码", example = "981223", required = true)
    })
    @PostMapping("/updatePassword")
    public void updatePassword(@RequestParam String password, @RequestParam String newPassword) {
        this.accountService.updatePassword(password, newPassword);
    }
}
