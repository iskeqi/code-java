package com.keqi.springbootmvcparam.controller;

import com.keqi.springbootmvcparam.common.AjaxEntity;
import com.keqi.springbootmvcparam.common.AjaxEntityBuilder;
import com.keqi.springbootmvcparam.domain.AccountParam;
import com.keqi.springbootmvcparam.domain.EnumParam;
import com.keqi.springbootmvcparam.emums.InspectionWorkStatusEnum;
import org.springframework.web.bind.annotation.*;

/**
 * 测试接收和序列化枚举类型
 */
@RestController
public class EnumController {

	/*
	总结：
		1) 不加 @RequestParam 注解，接收枚举参数和序列化枚举参数都没有问题。加了这个注解，就不行了
		2） 单个枚举类型参数接收，没有问题
		3) 对于使用了 @RequestBody 注解修饰的实体类，接收枚举参数和序列化枚举参数都没有问题
		4) 如果接收到的参数不是枚举中固定的值，会直接抛出异常：org.springframework.http.converter.HttpMessageNotReadableException

	 */



	@PostMapping("/enums/create")
	public AjaxEntity create(EnumParam enumParam) {
		// 接收枚举类型
		String name = enumParam.getName();
		InspectionWorkStatusEnum inspectionWorkStatus = enumParam.getInspectionWorkStatus();

		// 序列化枚举类型
		return AjaxEntityBuilder.success(enumParam);
	}

	@PostMapping("/enums/create2")
	public AjaxEntity create(InspectionWorkStatusEnum inspectionWorkStatus) {
		// 接收枚举类型
		System.out.println(inspectionWorkStatus);

		// 序列化枚举类型
		return AjaxEntityBuilder.success(inspectionWorkStatus);
	}

	@PostMapping("/enums/createJSON")
	public AjaxEntity createJSON(@RequestBody EnumParam enumParam) {
		// 接收枚举类型
		String name = enumParam.getName();
		InspectionWorkStatusEnum inspectionWorkStatus = enumParam.getInspectionWorkStatus();

		// 序列化枚举类型
		return AjaxEntityBuilder.success(enumParam);
	}
}
