package com.keqi.springbootmvcparam.controller;

import com.keqi.springbootmvcparam.common.AjaxEntity;
import com.keqi.springbootmvcparam.common.AjaxEntityBuilder;
import com.keqi.springbootmvcparam.domain.CommonParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonController {

	@GetMapping("/test1")
	public AjaxEntity test1(String idList) {
		return AjaxEntityBuilder.success(idList);
	}

	@GetMapping("/test2")
	public AjaxEntity test2(Long[] idList) {
		// 如果前端传递的是一个"1,2,3,4,5"的字符串
		// SpringMVC是可以直接转换成 Long[] 类型的数组的

		// 数组转List太容易了
		List<Long> longList = Arrays.asList(idList);

		return AjaxEntityBuilder.success(idList);
	}

	@GetMapping("/test3")
	public AjaxEntity test3(List<Long> idList) {
		// 如果前端传递的是一个"1,2,3,4,5"的字符串
		// SpringMVC是不支持直接转换成 List<Long> 类型的列表的
		// 这个接口会报错
		return AjaxEntityBuilder.success(idList);
	}

	@GetMapping("/test4")
	public AjaxEntity test4(CommonParam commonParam) {
		// 如果前端传递的是一个"1,2,3,4,5"的字符串
		// SpringMVC是可以直接转换成 Long[] 类型的数组的
		// 即便这个数组是封装在实体类中的
		return AjaxEntityBuilder.success(commonParam);
	}

	@PostMapping("/test5")
	public AjaxEntity test5(CommonParam commonParam) {
		// 如果前端传递的是一个"1,2,3,4,5"的字符串
		// SpringMVC是可以直接转换成 Long[] 类型的数组的
		// 即便这个数组是封装在实体类中的
		// 即便这是POST类型
		return AjaxEntityBuilder.success(commonParam);
	}

	/*

	总结：对于这种需要传递多个值，并且用英文的逗号分隔的字符串，
		是可以直接在 controller 中使用数组类型直接接收的，这样
		操作起来极其的方便。

		无论是使用GET类型请求，还是POST类型的 form-data或者是x-www-form-urlencoded
	 */
}
