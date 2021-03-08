package com.keqi.grid.sys.controller;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.RoleMenuPageParam;
import com.keqi.grid.sys.domain.param.RoleMenuParam;
import com.keqi.grid.sys.domain.vo.RoleMenuVO;
import com.keqi.grid.sys.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleMenuController {

	@Autowired
	private RoleMenuService roleMenuService;

	@PostMapping("/sys/roleMenu")
	public void insert(@Validated @RequestBody RoleMenuParam param) {
		this.roleMenuService.insert(param);
	}

	@PutMapping("/sys/roleMenu")
	public void updateById(@Validated @RequestBody RoleMenuParam param) {
		this.roleMenuService.updateById(param);
	}

	@DeleteMapping("/sys/roleMenu/{id}")
	public void deleteById(@PathVariable Long id) {
		this.roleMenuService.deleteById(id);
	}

	@PostMapping("/sys/roleMenu/page")
	public PageVO<RoleMenuVO> page(@RequestBody RoleMenuPageParam param) {
		return this.roleMenuService.page(param);
	}
}