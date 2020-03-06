package com.keqi.springboothibernatevalidator.controller;

import com.keqi.springboothibernatevalidator.common.AjaxEntity;
import com.keqi.springboothibernatevalidator.common.AjaxEntityBuilder;
import com.keqi.springboothibernatevalidator.domain.SysUserCreateBatchRequestParam;
import com.keqi.springboothibernatevalidator.domain.SysUserCreateRequestParam;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * "@Validated"注解的使用(推荐优先使用@Validated注解，除非不得不需要使用@Valid注解时)
 */
@RestController
@Validated
@RequestMapping("/2")
public class SysUserController2 {


	/**
	 * 表单以及GET方式提交参数（这种校验方式就能够生效）
	 * @param sysUserCreateRequestParam sysUserCreateRequestParam
	 * @return rstman
	 */
	@GetMapping("/sysUserCreate")
	public AjaxEntity sysUserCreateForm(@Validated SysUserCreateRequestParam sysUserCreateRequestParam) {
		System.out.println("====================");
		return AjaxEntityBuilder.success(sysUserCreateRequestParam);
	}

	/**
	 * 请求体为JSON时提交参数（这种校验方式就能够生效）
	 * @param sysUserCreateRequestParam sysUserCreateRequestParam
	 * @return r
	 */
	@PostMapping("/sysUserCreateJSON")
	public AjaxEntity sysUserCreateJSON(@Validated @RequestBody SysUserCreateRequestParam sysUserCreateRequestParam) {
		System.out.println("======================");
		return AjaxEntityBuilder.success(sysUserCreateRequestParam);
	}

	/**
	 * 表单以及GET方式提交单个参数（这种校验方式必须、必须、必须需要在控制器的类上使用@Validated注解，如果是使用@Valid注解是无效的）
	 * @param username username
	 * @return rstman
	 */
	@GetMapping("/sysUserCreateRequestParam2")
	public AjaxEntity sysUserCreateForm2(@Length(min = 3, message = "username长度不能小于3") String username) {
		System.out.println("====================");
		return AjaxEntityBuilder.success(username);
	}

	/**
	 * 请求体为JSON时提交参数（这种校验方式能够生效）（这个接口同时也演示了有嵌套子对象时，应该如何进行校验）
	 * @param sysUserCreateBatchRequestParam sysUserCreateBatchRequestParam
	 * @return r
	 */
	@PostMapping("/sysUserCreateJSONList2")
	public AjaxEntity sysUserCreateJSONList2(@Valid @RequestBody SysUserCreateBatchRequestParam sysUserCreateBatchRequestParam) {
		System.out.println("======================");
		return AjaxEntityBuilder.success(sysUserCreateBatchRequestParam);
	}

}
