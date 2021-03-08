package com.keqi.grid.sys.controller;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.AccountRolePageParam;
import com.keqi.grid.sys.domain.param.AccountRoleParam;
import com.keqi.grid.sys.domain.vo.AccountRoleVO;
import com.keqi.grid.sys.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountRoleController {

	@Autowired
	private AccountRoleService accountRoleService;

	@PostMapping("/sys/accountRole")
	public void insert(@Validated @RequestBody AccountRoleParam param) {
		this.accountRoleService.insert(param);
	}

	@PutMapping("/sys/accountRole")
	public void updateById(@Validated @RequestBody AccountRoleParam param) {
		this.accountRoleService.updateById(param);
	}

	@DeleteMapping("/sys/accountRole/{id}")
	public void deleteById(@PathVariable Long id) {
		this.accountRoleService.deleteById(id);
	}

	@PostMapping("/sys/accountRole/page")
	public PageVO<AccountRoleVO> page(@RequestBody AccountRolePageParam param) {
		return this.accountRoleService.page(param);
	}
}