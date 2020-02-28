package com.keqi.iotplatform.uc.controller;

import com.keqi.iotplatform.core.dynamic.domain.DataSourceBO;
import com.keqi.iotplatform.core.dynamic.service.DynamicService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {

	private final DataSourceBO dataSourceBO;
	private final DynamicService dynamicService;

	@GetMapping("/test1")
	public String test1() {
		return dataSourceBO.toString();
	}

	@GetMapping("/test2")
	public String test2() {
		return dynamicService.listAllDataSource().toString();
	}

}
