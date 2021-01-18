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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "5. 角色管理")
@ApiSupport(order = 5)
@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@ApiOperation(value = "5.1 新增角色")
	@ApiOperationSupport(order = 1, ignoreParameters = "param.id")
	@PostMapping("/sys/role")
	public void insert(@RequestBody RoleParam param) {
		this.roleService.insert(param);
	}

	@ApiOperation(value = "5.2 修改角色")
	@ApiOperationSupport(order = 2)
	@PutMapping("/sys/role")
	public void updateById(@RequestBody RoleParam param) {
		this.roleService.updateById(param);
	}

	@ApiOperation(value = "5.3 删除角色")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "角色ID", example = "1", required = true)
	@DeleteMapping("/sys/role/{id}")
	public void deleteById(@PathVariable Long id) {
		this.roleService.deleteById(id);
	}

	@ApiOperation(value = "5.4 分页查询角色列表")
	@ApiOperationSupport(order = 4)
	@PostMapping("/sys/role/page")
	public PageVO<RoleVO> page(@RequestBody RolePageParam param) {
		return this.roleService.page(param);
	}
}