package com.keqi.springboothibernatevalidator.controller;

import com.keqi.springboothibernatevalidator.common.AjaxEntity;
import com.keqi.springboothibernatevalidator.common.AjaxEntityBuilder;
import com.keqi.springboothibernatevalidator.domain.SysUserCreateBatchRequestParam;
import com.keqi.springboothibernatevalidator.domain.SysUserCreateRequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 *  "@Valid"注解的使用(不推荐这样用，推荐优先使用@Validated注解)
 */
@RestController
public class SysUserController {


	/**
	 * 表单以及GET方式提交参数（这种校验方式就能够生效）
	 * @param sysUserCreateRequestParam sysUserCreateRequestParam
	 * @return rstman
	 */
	@GetMapping("/sysUserCreate")
	public AjaxEntity sysUserCreateForm(@Valid SysUserCreateRequestParam sysUserCreateRequestParam) {
		System.out.println("====================");
		return AjaxEntityBuilder.success(sysUserCreateRequestParam);
	}

	/**
	 * 请求体为JSON时提交参数（这种校验方式就能够生效）
	 * @param sysUserCreateRequestParam sysUserCreateRequestParam
	 * @return r
	 */
	@PostMapping("/sysUserCreateJSON")
	public AjaxEntity sysUserCreateJSON(@Valid @RequestBody SysUserCreateRequestParam sysUserCreateRequestParam) {
		System.out.println("======================");
		return AjaxEntityBuilder.success(sysUserCreateRequestParam);
	}

	/**
	 * 请求体为JSON时提交参数（这种校验方式不能够生效，好像没有办法又能够校验还是数组的情况，这应该要封装成一个对象来才行）
	 * @param sysUserCreateRequestParam sysUserCreateRequestParam
	 * @return r
	 */
	@PostMapping("/sysUserCreateJSONList")
	public AjaxEntity sysUserCreateJSONList(@Valid @RequestBody List<SysUserCreateRequestParam> sysUserCreateRequestParam) {
		System.out.println("=======================");
		return AjaxEntityBuilder.success(sysUserCreateRequestParam);
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

	/**
	 * 表单以及GET方式提交单个参数（这种校验方式不能够生效，因为@Valid注解在@RequestParam上是无效的）
	 * @param username username
	 * @return rstman
	 */
	@GetMapping("/sysUserCreateRequestParam")
	public AjaxEntity sysUserCreateForm(@Valid @NotBlank String username) {
		System.out.println("====================");
		return AjaxEntityBuilder.success(username);
	}


}
