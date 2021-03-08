package com.keqi.grid.sys.controller;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.GridAccountPageParam;
import com.keqi.grid.sys.domain.param.GridAccountParam;
import com.keqi.grid.sys.domain.vo.GridAccountVO;
import com.keqi.grid.sys.service.GridAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class GridAccountController {

	@Autowired
	private GridAccountService gridAccountService;

	@PostMapping("/sys/gridAccount")
	public void insert(@Validated @RequestBody GridAccountParam param) {
		this.gridAccountService.insert(param);
	}

	@PutMapping("/sys/gridAccount")
	public void updateById(@Validated @RequestBody GridAccountParam param) {
		this.gridAccountService.updateById(param);
	}

	@DeleteMapping("/sys/gridAccount/{id}")
	public void deleteById(@PathVariable Long id) {
		this.gridAccountService.deleteById(id);
	}

	@PostMapping("/sys/gridAccount/page")
	public PageVO<GridAccountVO> page(@RequestBody GridAccountPageParam param) {
		return this.gridAccountService.page(param);
	}
}