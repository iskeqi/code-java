package com.keqi.apihu.manage.controller;

import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.manage.domain.AccountDO;
import com.keqi.apihu.manage.domain.AccountPageParam;
import com.keqi.apihu.manage.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

	private final AccountService accountService;

	/**
	 * 增加用户
	 * @param accountDO accountDO
	 * @return r
	 */
	@PostMapping("/account/create")
	public AjaxEntity create(AccountDO accountDO) {
		accountService.createAccount(accountDO);
		return AjaxEntityBuilder.success();
	}

	/**
	 * 删除用户
	 * @param accountId accountId
	 * @return r
	 */
	@PostMapping("/account/delete")
	public AjaxEntity delete(Integer accountId) {
		accountService.deleteAccount(accountId);
		return AjaxEntityBuilder.success();
	}

	/**
	 * 修改用户
	 * @param accountDO accountDO
	 * @return r
	 */
	@PostMapping("/account/update")
	public AjaxEntity update(AccountDO accountDO) {
		accountService.updateAccount(accountDO);
		return AjaxEntityBuilder.success();
	}

	/**
	 * 查询用户列表
	 * @param accountPageParam accountPageParam
	 * @return r
	 */
	@PostMapping("/account/page")
	public AjaxEntity page(AccountPageParam accountPageParam) {
		return AjaxEntityBuilder.success(accountService.pageAccount(accountPageParam));
	}
}
