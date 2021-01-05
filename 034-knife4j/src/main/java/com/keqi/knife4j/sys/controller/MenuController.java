package com.keqi.knife4j.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.sys.domain.param.MenuParam;
import com.keqi.knife4j.sys.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "6. 菜单管理")
@ApiSupport(order = 6)
@AllArgsConstructor
@RestController
public class MenuController {

	private final MenuService menuService;

	@ApiOperation(value = "6.1 新增菜单")
	@ApiOperationSupport(order = 1, ignoreParameters = "menuParam.id")
	@PostMapping("/sys/menu/create")
	public void create(@RequestBody MenuParam menuParam) {
		this.menuService.insert(menuParam);
	}

	@ApiOperation(value = "6.2 根据ID修改菜单")
	@ApiOperationSupport(order = 2)
	@PostMapping("/sys/menu/updateById")
	public void updateById(@RequestBody MenuParam menuParam) {
		this.menuService.updateById(menuParam);
	}

	@ApiOperation(value = "6.3 根据ID删除菜单")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "菜单ID", example = "1", required = true)
	@PostMapping("/sys/menu/deleteById")
	public void deleteById(@RequestParam Long id) {
		this.menuService.deleteById(id);
	}
}