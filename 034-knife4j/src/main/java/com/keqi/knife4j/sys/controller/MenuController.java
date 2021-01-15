package com.keqi.knife4j.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.core.auth.Auth;
import com.keqi.knife4j.sys.domain.param.MenuParam;
import com.keqi.knife4j.sys.domain.vo.MenuVO;
import com.keqi.knife4j.sys.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "6. 菜单管理")
@ApiSupport(order = 6)
@AllArgsConstructor
@RestController
public class MenuController {

	private final MenuService menuService;

	@ApiOperation(value = "6.1 新增菜单")
	@ApiOperationSupport(order = 1, ignoreParameters = "menuParam.id")
	@PostMapping("/sys/menu")
	public void create(@RequestBody MenuParam menuParam) {
		this.menuService.insert(menuParam);
	}

	@ApiOperation(value = "6.2 修改菜单")
	@ApiOperationSupport(order = 2)
	@PutMapping("/sys/menu")
	public void updateById(@RequestBody MenuParam menuParam) {
		this.menuService.updateById(menuParam);
	}

	@ApiOperation(value = "6.3 删除菜单")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "菜单ID", example = "1", required = true)
	@DeleteMapping("/sys/menu/{id}")
	public void deleteById(@PathVariable Long id) {
		this.menuService.deleteById(id);
	}

	@ApiOperation(value = "6.4 查询当前用户菜单列表")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/menu/queryTheCurrentUserMenuList")
	public List<MenuVO> queryTheCurrentUserMenuList() {
		return this.menuService.queryTheCurrentUserMenuList(Auth.getLoginAccountId());
	}
}