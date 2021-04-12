package com.keqi.springbootmvctrain.controller;

import com.keqi.springbootmvctrain.domain.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * ConverterDemoController
 *
 * @author keqi
 */
@RestController
@RequestMapping("converterDemoController")
public class ConverterDemoController {

	/*
		尽管 SpringMVC 提供了各种数据类型的参数转换机制，但有时我们仍然需要定制一些自己的类型转换器

		SpringMVC 中的类型转换器分为两种（两者并不）：
			@ReqeustParam 注解

				走的是 org.springframework.core.convert.converter.Converter 通道

			@ReqeustBody 注解

				走的是 org.springframework.http.converter.HttpMessageConverter 通道，
	 */

	/*
		常用的需要定制的类型转换器有以下这些：

			1、LocalDateTime 和 yyyy-MM-dd HH:mm:ss 的互相转换
			2、LocalDate 和 yyyy-MM-dd 的互相转换
			3、Date 和 yyyy-MM-dd HH:mm:ss 的互相转换（不推荐使用这个类，能不用就不用）

			4、String 和 Number 之间的转换
	 */

	@GetMapping("/test1")
	public Map<String, Object> test1(String name, @RequestParam Integer age) {
		Map<String, Object> r = new HashMap<>();
		r.put("name", name);
		r.put("age", age);
		return r;
	}

	@PutMapping("/test2")
	public Map<String, Object> test2(Teacher teacher, HttpServletRequest request) {
		Map<String, Object> r = new HashMap<>();
		r.put("Content-Type", request.getContentType());
		r.put("teacher", teacher);
		return r;
	}

	@PostMapping("/test3")
	public Map<String, Object> test3(@RequestBody Teacher teacher, HttpServletRequest request) {
		Map<String, Object> r = new HashMap<>();
		r.put("Content-Type", request.getContentType());
		r.put("teacher", teacher);
		return r;
	}

}
