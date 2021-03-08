package com.keqi.grid.sys.controller;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.AccountPageParam;
import com.keqi.grid.sys.domain.param.AccountParam;
import com.keqi.grid.sys.domain.vo.AccountVO;
import com.keqi.grid.sys.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/sys/account")
	public void insert(@Validated @RequestBody AccountParam param) {
		this.accountService.insert(param);
	}

	@PutMapping("/sys/account")
	public void updateById(@Validated @RequestBody AccountParam param) {
		this.accountService.updateById(param);
	}

	@DeleteMapping("/sys/account/{id}")
	public void deleteById(@PathVariable Long id) {
		this.accountService.deleteById(id);
	}

	@PostMapping("/sys/account/page")
	public PageVO<AccountVO> page(@RequestBody AccountPageParam param) {
		return this.accountService.page(param);
	}
}