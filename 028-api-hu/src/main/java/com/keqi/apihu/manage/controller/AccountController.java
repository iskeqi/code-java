package com.keqi.apihu.manage.controller;

import com.keqi.apihu.manage.domain.AccountDO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@PostMapping("/account/create")
	public void create(AccountDO accountDO) {

	}
}
