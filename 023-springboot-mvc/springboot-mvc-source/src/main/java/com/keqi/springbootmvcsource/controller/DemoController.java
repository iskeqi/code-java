package com.keqi.springbootmvcsource.controller;

import com.keqi.springbootmvcsource.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * DemoController
 *
 * @author keqi
 */
@Controller
public class DemoController {

	@GetMapping("/hello")
	public String hello(String name) {
		HandlerMethodArgumentResolver handlerMethodArgumentResolver;
		DispatcherServlet dispatcherServlet;
		return "hello " + name;
	}

	@GetMapping("/hello2")
	@ResponseBody
	public Student hello2() {
		Student student = new Student();
		student.setName("keqi");
		student.setAge(12);
		return student;
	}

	@GetMapping("/hello3")
	@ResponseBody
	public Student hello3() {
		Student student = new Student();
		student.setName("keqi");
		student.setAge(12);
		throw new RuntimeException(student.toString());
	}
}