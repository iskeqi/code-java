package com.keqi.knife4j.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.RolePageParam;
import com.keqi.knife4j.sys.domain.param.RoleParam;
import com.keqi.knife4j.sys.domain.vo.RoleVO;
import com.keqi.knife4j.sys.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = "5. 角色管理")
@ApiSupport(order = 5)
@AllArgsConstructor
@RestController
public class RoleController {

	private final RoleService roleService;

	@ApiOperation(value = "5.1 新增角色")
	@ApiOperationSupport(order = 1, ignoreParameters = "roleParam.id")
	@PostMapping("/sys/role/create")
	public void create(@RequestBody RoleParam roleParam) {
		this.roleService.insert(roleParam);
	}

	@ApiOperation(value = "5.2 根据ID修改角色")
	@ApiOperationSupport(order = 2)
	@PostMapping("/sys/role/updateById")
	public void updateById(@RequestBody RoleParam roleParam) {
		this.roleService.updateById(roleParam);
	}

	@ApiOperation(value = "5.3 根据ID删除角色")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "角色ID", example = "1", required = true)
	@PostMapping("/sys/role/deleteById")
	public void deleteById(@RequestParam Long id) {
		this.roleService.deleteById(id);
	}

	@ApiOperation(value = "5.4 分页查询角色列表")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/role/page")
	public PageVO<RoleVO> page(@RequestBody RolePageParam pageParam) {
		return this.roleService.page(pageParam);
	}
}