package com.keqi.apihu.manage.controller;

import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.manage.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

	private final AccountService accountService;

	/**
	 * 登录
	 * @param account account
	 * @param password password
	 * @return
	 */
	@PostMapping("/auth/login")
	public AjaxEntity login(String account, String password) {
		return AjaxEntityBuilder.success(accountService.login(account, password));
	}
}
