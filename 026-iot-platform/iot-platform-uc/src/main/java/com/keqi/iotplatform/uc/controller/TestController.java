package com.keqi.iotplatform.uc.controller;

import com.keqi.iotplatform.core.domain.AjaxEntity;
import com.keqi.iotplatform.core.domain.AjaxEntityBuilder;
import com.keqi.iotplatform.core.domain.PageParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
