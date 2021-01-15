package com.keqi.knife4j.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.sys.domain.param.LoginParam;
import com.keqi.knife4j.sys.domain.param.UpdatePasswordParam;
import com.keqi.knife4j.sys.domain.vo.LoginVO;
import com.keqi.knife4j.sys.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "1. 登录管理")
@ApiSupport(order = 1)
@Validated
@AllArgsConstructor
@RestController
public class AuthController {

	private final AccountService accountService;

	@ApiOperation(value = "1.1 登录")
	@ApiOperationSupport(order = 1)
	@PostMapping("/sys/auth/login")
	public LoginVO login(@Validated @RequestBody LoginParam param) {
		return this.accountService.login(param.getAccount(), param.getPassword());
	}

	@ApiOperation(value = "1.2 修改密码")
	@ApiOperationSupport(order = 2)
	@PostMapping("/sys/auth/updatePassword")
	public void updatePassword(@Validated @RequestBody UpdatePasswordParam param) {
		this.accountService.updatePassword(param.getPassword(), param.getNewPassword());
	}
}
