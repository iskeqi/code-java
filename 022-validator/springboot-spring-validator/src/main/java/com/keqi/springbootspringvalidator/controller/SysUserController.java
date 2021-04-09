package com.keqi.springbootspringvalidator.controller;

import com.keqi.springbootspringvalidator.common.AjaxEntity;
import com.keqi.springbootspringvalidator.common.AjaxEntityBuilder;
import com.keqi.springbootspringvalidator.domain.SysUserCreateBatchRequestParam;
import com.keqi.springbootspringvalidator.domain.SysUserCreateRequestParam;
import com.keqi.springbootspringvalidator.service.SysUserService;
import com.keqi.springbootspringvalidator.util.SpringValidatorUtil;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * "@Validated"注解的使用(推荐优先使用@Validated注解，除非不得不需要使用@Valid注解时)
 */
@RestController
@Validated
@AllArgsConstructor
public class SysUserController {

	private final SysUserService sysUserService;

	// 这里导入的是 javax.validation.Validator
	private final Validator validator;

	// 自己基于 javax.validation.Validator 封装的工具类
	private final SpringValidatorUtil springValidatorUtil;

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
	 * 表单以及GET方式提交单个参数（这种校验方式必须、必须、必须需要在控制器的类上使用@Validated注解，即便放在方法上也无效，@Valid注解就更是了）
	 * @param username username
	 * @return rstman
	 */
	@GetMapping("/sysUserCreateRequestParam2")
	public AjaxEntity sysUserCreateForm2(@Length(min = 3, message = "username长度不能小于3") String username) {
		System.out.println("====================");
		return AjaxEntityBuilder.success(username);
	}

	/**
	 * 请求体为JSON时提交参数（这种校验方式能够生效）（这个接口同时也演示了有嵌套子对象时，应该如何进行校验）(这种场景不得不使用@Valid注解)
	 * @param sysUserCreateBatchRequestParam sysUserCreateBatchRequestParam
	 * @return r
	 */
	@PostMapping("/sysUserCreateJSONList2")
	public AjaxEntity sysUserCreateJSONList2(@Valid @RequestBody SysUserCreateBatchRequestParam sysUserCreateBatchRequestParam) {
		System.out.println("======================");
		return AjaxEntityBuilder.success(sysUserCreateBatchRequestParam);
	}

	/**
	 * 表单以及GET方式提交单个参数（测试Service层接口中是否能够生效）
	 * @param username username
	 * @return rstman
	 */
	@GetMapping("/sysUserCreateRequestParam2Service")
	public AjaxEntity sysUserCreateForm2Service(String username) {
		System.out.println("====================");
		this.sysUserService.sysUserCreateForm2Service(username);
		return AjaxEntityBuilder.success(username);
	}

	/**
	 * 手动校验的方式
	 *
	 * @return rstman
	 */
	@GetMapping("/manualValidator")
	public AjaxEntity manualValidator() {



		SysUserCreateRequestParam sysUserCreateRequestParam = new SysUserCreateRequestParam();
		sysUserCreateRequestParam.setUserEmail("1209023760");
		List<SysUserCreateRequestParam> list = new ArrayList<>();
		list.add(sysUserCreateRequestParam);

		SysUserCreateBatchRequestParam param = new SysUserCreateBatchRequestParam();
		param.setSysUserList(list);

		/*
		javax.validation.Validator 类的 validate() 方法返回值是一个Set<ConstraintViolation<T>>类型的集合，对于不满足要求的参数，就会
		生成一个ConstraintViolation对象，并把错误信息封装在它的 message 属性中。

		可见，实际使用过程中，应该封装一个工具类，只需要一行代码，然后在不符合校验规则的情况下，就直接抛出异常即可。
			此种方式支持嵌套子对象的校验！
		 */
		Set<ConstraintViolation<SysUserCreateRequestParam>> constraintViolationSet = validator.validate(sysUserCreateRequestParam);

		for (ConstraintViolation<SysUserCreateRequestParam> sysUserCreateRequestParamConstraintViolation : constraintViolationSet) {
			String message = sysUserCreateRequestParamConstraintViolation.getMessage();
			System.out.println(message);
		}


		if (springValidatorUtil.validate(sysUserCreateRequestParam)) {
			// 校验通过
		}

		return AjaxEntityBuilder.success();
	}
}
