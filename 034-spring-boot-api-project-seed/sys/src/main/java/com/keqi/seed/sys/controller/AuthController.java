package com.keqi.seed.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.seed.sys.domain.param.LoginParam;
import com.keqi.seed.sys.domain.param.UpdatePasswordParam;
import com.keqi.seed.sys.domain.vo.AccountDetailVO;
import com.keqi.seed.sys.domain.vo.LoginVO;
import com.keqi.seed.sys.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "1. 登录管理")
@ApiSupport(order = 1)
@Validated
@RestController
public class AuthController {

	@Autowired
	private AccountService accountService;

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

	@ApiOperation(value = "1.3 获取登录用户信息")
	@ApiOperationSupport(order = 3)
	@PostMapping("/sys/auth/getLoginUserInfo")
	public AccountDetailVO getLoginUserInfo() {
		return this.accountService.selectLoginUserInfo();
	}

	@ApiOperation(value = "1.4 注销")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/auth/logout")
	public void logout() {

	}
}
