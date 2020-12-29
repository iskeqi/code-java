package com.keqi.knife4j.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.sys.aspect.Log;
import com.keqi.knife4j.sys.domain.param.AccountParam;
import com.keqi.knife4j.sys.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "4. 用户管理")
@ApiSupport(order = 4)
@AllArgsConstructor
@RestController
public class AccountController {

	private final AccountService accountService;

	@ApiOperation(value = "4.1 新增用户")
	@ApiOperationSupport(order = 1)
	@Log("新增用户")
	@PostMapping("/sys/account/create")
	public void create(@Validated @RequestBody AccountParam accountParam) {
		this.accountService.insert(accountParam);
	}
}
