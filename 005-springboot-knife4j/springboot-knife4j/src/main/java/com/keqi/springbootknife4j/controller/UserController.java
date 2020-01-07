package com.keqi.springbootknife4j.controller;

import com.keqi.springbootknife4j.common.ResponseResult;
import com.keqi.springbootknife4j.domain.User;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", produces = "application/json")
@Api(value = "User", tags = {"User"}, description = "用户相关")
public class UserController {


	@ApiOperation(value = "使用ID查询用户")
	@ApiImplicitParams({
			//
			@ApiImplicitParam(value = "id", name = "id", dataType = "int", paramType = "path", required = true, defaultValue = "1")
	})
	@ApiResponses({
			@ApiResponse(code = 400, message = "请求参数有误"),
			@ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "禁止访问"),
			@ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")
	})
	@GetMapping("/{id}")
	public ResponseResult<User> getById(@PathVariable("id") Integer id) {
		return new ResponseResult<User>();
	}

	@PostMapping("")
	@ApiOperation(value = "创建用户")
	@ApiResponses({
			@ApiResponse(code = 400, message = "请求参数有误"),
			@ApiResponse(code = 401, message = "未授权"),
			@ApiResponse(code = 403, message = "禁止访问"),
			@ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")
	})
	public ResponseResult<User> createUser(@Validated @RequestBody User user) {
		return new ResponseResult<User>();
	}
}
