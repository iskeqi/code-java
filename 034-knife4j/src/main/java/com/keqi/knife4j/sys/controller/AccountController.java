package com.keqi.knife4j.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.AccountPageParam;
import com.keqi.knife4j.sys.domain.param.AccountParam;
import com.keqi.knife4j.sys.domain.vo.AccountVO;
import com.keqi.knife4j.sys.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "4. 用户管理")
@ApiSupport(order = 4)
@AllArgsConstructor
@RestController
public class AccountController {

	private final AccountService accountService;

	@ApiOperation(value = "4.1 新增用户")
	@ApiOperationSupport(order = 1, ignoreParameters = "accountParam.id")
	@PostMapping("/sys/account/create")
	public void create(@Validated @RequestBody AccountParam accountParam) {
		this.accountService.insert(accountParam);
	}

	@ApiOperation(value = "5.2 根据ID修改用户")
	@ApiOperationSupport(order = 2)
	@PostMapping("/sys/account/updateById")
	public void updateById(@RequestBody AccountParam accountParam) {
		this.accountService.updateById(accountParam);
	}

	@ApiOperation(value = "5.3 根据ID删除用户")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "用户ID", example = "1", required = true)
	@PostMapping("/sys/account/deleteById")
	public void deleteById(@RequestParam Long id) {
		this.accountService.deleteById(id);
	}

	@ApiOperation(value = "5.4 分页查询用户列表")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/account/page")
	public PageVO<AccountVO> page(@RequestBody AccountPageParam pageParam) {
		return this.accountService.page(pageParam);
	}
}
