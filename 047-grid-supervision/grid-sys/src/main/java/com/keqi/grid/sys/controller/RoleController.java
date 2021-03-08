package com.keqi.grid.sys.controller;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.RolePageParam;
import com.keqi.grid.sys.domain.param.RoleParam;
import com.keqi.grid.sys.domain.vo.RoleVO;
import com.keqi.grid.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping("/sys/role")
	public void insert(@Validated @RequestBody RoleParam param) {
		this.roleService.insert(param);
	}

	@PutMapping("/sys/role")
	public void updateById(@Validated @RequestBody RoleParam param) {
		this.roleService.updateById(param);
	}

	@DeleteMapping("/sys/role/{id}")
	public void deleteById(@PathVariable Long id) {
		this.roleService.deleteById(id);
	}

	@PostMapping("/sys/role/page")
	public PageVO<RoleVO> page(@RequestBody RolePageParam param) {
		return this.roleService.page(param);
	}
}