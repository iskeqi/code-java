package com.keqi.springbootmvcsource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * DemoController
 *
 * @author keqi
 */
@RestController
public class DemoController {

	@GetMapping("/hello")
	public String hello(String name) {
		HandlerMethodArgumentResolver handlerMethodArgumentResolver;
		DispatcherServlet dispatcherServlet;
		return "hello " + name;
	}

}
