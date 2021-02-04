package com.keqi.seed.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.seed.sys.pojo.Auth;
import com.keqi.seed.sys.domain.param.MenuParam;
import com.keqi.seed.sys.domain.vo.MenuVO;
import com.keqi.seed.sys.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "6. 菜单管理")
@ApiSupport(order = 6)
@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;

	@ApiOperation(value = "6.1 新增菜单")
	@ApiOperationSupport(order = 1, ignoreParameters = "param.id")
	@PostMapping("/sys/menu")
	public void insert(@RequestBody MenuParam param) {
		this.menuService.insert(param);
	}

	@ApiOperation(value = "6.2 修改菜单")
	@ApiOperationSupport(order = 2)
	@PutMapping("/sys/menu")
	public void updateById(@RequestBody MenuParam param) {
		this.menuService.updateById(param);
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
	@GetMapping("/sys/menu/selectMenusByAccountId")
	public List<MenuVO> selectMenusByAccountId() {
		return this.menuService.selectMenusByAccountId(Auth.getLoginAccountId());
	}
}