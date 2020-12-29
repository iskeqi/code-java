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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;

@Api(tags = "1. 登录管理")
@ApiSupport(order = 1)
@Validated
@AllArgsConstructor
@RestController
public class AuthController {

	private final AccountService accountService;

	@ApiOperation(value = "1.1 登录")
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "account", value = "账号", example = "admin", required = true),
			@ApiImplicitParam(name = "password", value = "密码", example = "123456", required = true)
	})
	@GetMapping("/sys/auth/login")
	public LoginVO login(
			@Size(min = 2, max = 10, message = "用户名长度必须在2-10个字符之间") @RequestParam String account,
			@Size(min = 6, max = 20, message = "密码长度必须在6-20个字符之间") @RequestParam String password) {
		return this.accountService.login(account, password);
	}

	@ApiOperation(value = "1.2 修改密码")
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "password", value = "原密码", example = "123456", required = true),
			@ApiImplicitParam(name = "newPassword", value = "新密码", example = "981223", required = true)
	})
	@PostMapping("/sys/auth/updatePassword")
	public void updatePassword(
			@Size(min = 2, max = 10, message = "用户名长度必须在2-10个字符之间") @RequestParam String password,
			@Size(min = 6, max = 20, message = "密码长度必须在6-20个字符之间") @RequestParam String newPassword) {
		this.accountService.updatePassword(password, newPassword);
	}
}
