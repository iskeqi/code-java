package com.keqi.springbootmvctrain.controller;

import com.keqi.springbootmvctrain.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * DemoController
 *
 * @author keqi
 */
@Slf4j
@RestController
@RequestMapping("demoController")
public class DemoController {

	/*
		Controller 中获取请求参数，可以分为三种：
			1、从 URL 路径中获取请求参数，包括请求路径中的参数和 GET 请求中 ? 后面的参数
			2、从 header 中获取参数
			3、从 body 中获取请求参数，分为三种：application/json ，application/x-www-form-urlencoded，multipart/form-data

	 */


	// 从 url 中获取参数
	@GetMapping("/test1")
	public Map<String, Object> test1(String name, @RequestParam Integer age) {
		Map<String, Object> r = new HashMap<>();
		r.put("name", name);
		r.put("age", age);
		log.info(r.toString());
		return r;
	}

	@DeleteMapping("/test2/{id}")
	public Map<String, Object> test2(String name, @RequestParam Integer age, @PathVariable Integer id) {
		Map<String, Object> r = new HashMap<>();
		r.put("name", name);
		r.put("age", age);
		r.put("id", id);
		return r;
	}

	// 从 header 中获取数据

	@GetMapping("/test3")
	public Map<String, Object> test3(@RequestHeader String token) {
		Map<String, Object> r = new HashMap<>();
		r.put("token", token);
		return r;
	}

	// 从 cookie 中获取数据

	@GetMapping("/test4")
	public Map<String, Object> test4(@CookieValue String jSessionId) {
		Map<String, Object> r = new HashMap<>();
		r.put("jSessionId", jSessionId);
		return r;
	}

	// 获取到 Servlet 规范中的 request 和 response 对象

	@GetMapping("/test5")
	public Map<String, Object> test5(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> r = new HashMap<>();
		// Get 请求方式发送的 HTTP 请求，对应的 Content-Type 是 null
		r.put("Content-Type", request.getContentType());
		r.put("request", request.toString());
		r.put("response", response.toString());
		return r;
	}

	// 从 HTTP 请求体中获取 application/x-www-form-urlencoded 类型的请求参数，用于 POST/PUT 请求传递非 json 参数
	// 不推荐此种用法

	@PostMapping("/test6")
	public Map<String, Object> test6(String name, @RequestParam Integer age, HttpServletRequest request) {
		Map<String, Object> r = new HashMap<>();
		r.put("Content-Type", request.getContentType());
		r.put("name", name);
		r.put("age", age);
		return r;
	}

	@PutMapping("/test7")
	public Map<String, Object> test7(Student student, HttpServletRequest request) {
		Map<String, Object> r = new HashMap<>();
		r.put("Content-Type", request.getContentType());
		r.put("student", student);
		return r;
	}

	// 从 HTTP 请求体中获取 multipart/form-data 类型的请求参数，用于文件上传

	@PostMapping("/test8")
	public Map<String, Object> test8(MultipartFile file, HttpServletRequest request) {
		Map<String, Object> r = new HashMap<>();
		r.put("Content-Type", request.getContentType());
		r.put("file", file.getOriginalFilename());
		return r;
	}

	// 从 HTTP 请求体中获取 application/json 类型的请求参数，用于传递 json 数据
	// 推荐使用

	@PostMapping("/test9")
	public Map<String, Object> test9(@RequestBody Student student, HttpServletRequest request) {
		Map<String, Object> r = new HashMap<>();
		r.put("Content-Type", request.getContentType());
		r.put("student", student);
		return r;
	}

	@PutMapping("/test10")
	public Map<String, Object> test10(@RequestBody Student student, HttpServletRequest request) {
		Map<String, Object> r = new HashMap<>();
		r.put("Content-Type", request.getContentType());
		r.put("student", student);
		return r;
	}

}
