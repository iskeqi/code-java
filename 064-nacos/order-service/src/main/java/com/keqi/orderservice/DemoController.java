package com.keqi.orderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoController {

	@Resource
	private UserClient userClient;

	@GetMapping("/test/{id}")
	public User test(@PathVariable Long id) {
		return userClient.findById(id);
	}
}
