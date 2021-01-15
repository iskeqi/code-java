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
import org.springframework.web.bind.annotation.*;

@Api(tags = "4. 用户管理")
@ApiSupport(order = 4)
@AllArgsConstructor
@RestController
public class AccountController {

	private final AccountService accountService;

	@ApiOperation(value = "4.1 新增用户")
	@ApiOperationSupport(order = 1, ignoreParameters = "param.id")
	@PostMapping("/sys/account")
	public void create(@Validated @RequestBody AccountParam param) {
		this.accountService.insert(param);
	}

	@ApiOperation(value = "5.2 修改用户")
	@ApiOperationSupport(order = 2, ignoreParameters = {"param.account", "param.password"})
	@PutMapping("/sys/account")
	public void updateById(@Validated @RequestBody AccountParam param) {
		this.accountService.updateById(param);
	}

	@ApiOperation(value = "5.3 删除用户")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "用户ID", example = "1", required = true)
	@DeleteMapping("/sys/account/{id}")
	public void deleteById(@PathVariable Long id) {
		this.accountService.deleteById(id);
	}

	@ApiOperation(value = "5.4 分页查询用户列表")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/account/page")
	public PageVO<AccountVO> page(@RequestBody AccountPageParam param) {
		return this.accountService.page(param);
	}
}
