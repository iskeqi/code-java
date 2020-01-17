package com.keqi.springbootswagger2.controller;

import com.keqi.springbootswagger2.common.AjaxEntity;
import com.keqi.springbootswagger2.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "SysUser API")
@RestController
@RequestMapping(value = "/user")
public class UserController {


	@ApiOperation(value="添加用户信息", notes="添加用户信息")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true)
	@ResponseBody
	@RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
	public AjaxEntity addUser(User user){
		return AjaxEntity.success();
	}

	@ApiOperation(value="查看信息", notes="查看用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int"),
			@ApiImplicitParam(name = "pageSize", value = "每页个数", required = true, dataType = "int")
	})
	@ResponseBody
	@RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
	public AjaxEntity findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
		return AjaxEntity.list(100L, null);
	}
}
