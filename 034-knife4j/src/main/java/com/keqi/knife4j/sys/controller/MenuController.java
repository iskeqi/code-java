package com.keqi.knife4j.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.MenuPageParam;
import com.keqi.knife4j.sys.domain.param.MenuParam;
import com.keqi.knife4j.sys.domain.vo.MenuVO;
import com.keqi.knife4j.sys.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = "1. 菜单管理")
@ApiSupport(order = 1)
@AllArgsConstructor
@RestController
public class MenuController {

	private final MenuService menuService;

	@ApiOperation(value = "1.1 新增菜单")
	@ApiOperationSupport(order = 1, ignoreParameters = "menuParam.id")
	@PostMapping("/sys/menu/create")
	public void create(@RequestBody MenuParam menuParam) {

	}

	@ApiOperation(value = "1.2 根据ID修改菜单")
	@ApiOperationSupport(order = 2)
	@PostMapping("/sys/menu/updateById")
	public void updateById(@RequestBody MenuParam menuParam) {

	}

	@ApiOperation(value = "1.3 根据ID删除菜单")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "菜单ID", example = "1", required = true)
	@PostMapping("/sys/menu/deleteById")
	public void deleteById(@RequestParam Long id) {

	}

	@ApiOperation(value = "1.4 分页查询菜单列表")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/menu/page")
	public PageVO<MenuVO> page(@RequestBody MenuPageParam pageParam) {
		return null;
	}
}