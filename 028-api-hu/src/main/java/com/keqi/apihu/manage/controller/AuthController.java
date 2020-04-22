package com.keqi.apihu.manage.controller;

import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.core.common.Auth;
import com.keqi.apihu.manage.domain.param.ListMyProjectParam;
import com.keqi.apihu.manage.service.AccountService;
import com.keqi.apihu.manage.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {

	private final AccountService accountService;
	private final ProjectService projectService;

	@PostMapping("/auth/login")
	public AjaxEntity login(String account, String password) {
		return AjaxEntityBuilder.success(accountService.login(account, password));
	}

	@PostMapping("/auth/resetPassword")
	public AjaxEntity resetPassword() {
		accountService.resetPassword(Auth.getLoginAccount());
		return AjaxEntityBuilder.success();
	}

	@PostMapping("/auth/updatePassword")
	public AjaxEntity updatePassword(String oldPassword, String newPassword) {
		accountService.updatePassword(Auth.getLoginAccount(), oldPassword, newPassword);
		return AjaxEntityBuilder.success();
	}

	@GetMapping("/auth/currentUser")
	public AjaxEntity getCurrentLoginInfo() {
		return AjaxEntityBuilder.success(Auth.getLoginUserBO());
	}

	@PostMapping("/auth/myProject")
	public AjaxEntity listMyProject(@RequestBody ListMyProjectParam listMyProjectParam) {
		return AjaxEntityBuilder.success(this.projectService.listMyProject(listMyProjectParam));
	}
}
