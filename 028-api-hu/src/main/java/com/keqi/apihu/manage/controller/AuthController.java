package com.keqi.apihu.manage.controller;

import com.keqi.apihu.core.common.*;
import com.keqi.apihu.manage.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {

	private final AccountService accountService;

	/**
	 * 用户登录
	 *
	 * @param account  account
	 * @param password password
	 * @return r
	 */
	@PostMapping("/auth/login")
	public AjaxEntity login(String account, String password) {
		return AjaxEntityBuilder.success(accountService.login(account, password));
	}

	/**
	 * 重置密码
	 *
	 * @return r
	 */
	@PostMapping("/auth/resetPassword")
	public AjaxEntity resetPassword() {
		accountService.updatePassword(Auth.getLoginAccount(), CommonConstant.DEFAULT_PASSWORD);
		return AjaxEntityBuilder.success();
	}

	/**
	 * 当前登录用户更改自己的密码
	 *
	 * @param password password
	 * @return r
	 */
	@PostMapping("/auth/updatePassword")
	public AjaxEntity updatePassword(String password) {
		accountService.updatePassword(Auth.getLoginAccount(), password);
		return AjaxEntityBuilder.success();
	}

	/**
	 * 获取当前登录用户信息
	 *
	 * @return r
	 */
	@GetMapping("/auth/currentUser")
	public AjaxEntity getCurrentLoginInfo() {
		return AjaxEntityBuilder.success(Auth.getLoginUserBO());
	}
}
