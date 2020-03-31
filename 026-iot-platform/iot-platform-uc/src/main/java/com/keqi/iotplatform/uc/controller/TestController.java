package com.keqi.iotplatform.uc.controller;

import com.keqi.iotplatform.core.domain.AjaxEntity;
import com.keqi.iotplatform.core.domain.AjaxEntityBuilder;
import com.keqi.iotplatform.core.domain.PageParam;
import com.keqi.iotplatform.core.domain.QueryBaseParam;
import com.keqi.iotplatform.uc.domain.QueryBaseParam2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

	@GetMapping("/test1")
	public AjaxEntity test1() {
		PageParam pageParam = new PageParam();
		pageParam.setPageNum(1);
		return AjaxEntityBuilder.success(pageParam);
	}

	@GetMapping("/test2")
	public AjaxEntity test2() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		return AjaxEntityBuilder.success(list);
	}

	@GetMapping("/test3")
	public AjaxEntity test3(QueryBaseParam queryBaseParam) {
		// 在实体类上使用 @DateTimeFormat(pattern = "yyyy-MM-dd") 注解的确很灵活
		// 但是有一个致命的问题就是，如果这是一个可选参数，前端给你传递了""的话，参数就接收不成功
		// 按道理来说，是应该传递null或者是不传的，但是前端不肯改。。
		// 没办法，只好换一种方式了，那就是自定义 Converter 实现类
		return AjaxEntityBuilder.success(queryBaseParam);
	}

	@PostMapping("/test4")
	public AjaxEntity test4(@RequestBody QueryBaseParam2 queryBaseParam2) {
		// 在实体类上使用 @DateTimeFormat(pattern = "yyyy-MM-dd") 注解的确很灵活
		// 但是有一个致命的问题就是，如果这是一个可选参数，前端给你传递了""的话，参数就接收不成功
		// 按道理来说，是应该传递null或者是不传的，但是前端不肯改。。
		// 没办法，只好换一种方式了，那就是自定义 Converter 实现类
		return AjaxEntityBuilder.success(queryBaseParam2);
	}

	@PostMapping("/test5")
	public AjaxEntity test5(QueryBaseParam2 queryBaseParam2) {
		// 这种场景必须要添加注解才行
		// 总结：还是直接使用 application/json 是最好的
		return AjaxEntityBuilder.success(queryBaseParam2);
	}
}
