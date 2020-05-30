package com.keqi.mavenspringbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/test")
	public String test(String name) {
		return name;
	}
}
