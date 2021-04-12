package com.keqi.springbootmvctrain.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.springbootmvctrain.domain.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "Knife4jDemoController")
@ApiSupport(order = 1, author = "keqi")
@RestController
@RequestMapping("/knife4jDemoController")
public class Knife4jDemoController {

	// 从 url 中获取参数
	@ApiOperation(value = "test1", notes = "这是接口备注信息，可不填")
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "name", value = "姓名", example = "keqi"),
			@ApiImplicitParam(name = "age", value = "年龄", example = "12", required = true)
	})
	@GetMapping("/test1")
	public Map<String, Object> test1(String name, @RequestParam Integer age) {
		Map<String, Object> r = new HashMap<>();
		r.put("name", name);
		r.put("age", age);
		return r;
	}

	@ApiOperation(value = "test2")
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "name", value = "姓名", example = "keqi"),
			@ApiImplicitParam(name = "age", value = "年龄", example = "12", required = true),
			@ApiImplicitParam(name = "id", value = "id", example = "12", required = true)
	})
	@DeleteMapping("/test2/{id}")
	public Map<String, Object> test2(String name, @RequestParam Integer age, @PathVariable Integer id) {
		Map<String, Object> r = new HashMap<>();
		r.put("name", name);
		r.put("age", age);
		r.put("id", id);
		return r;
	}

	// 从 header 中获取数据

	@ApiOperation(value = "test3")
	@ApiOperationSupport(order = 3)
	@GetMapping("/test3")
	public Map<String, Object> test3(@RequestHeader String token) {
		Map<String, Object> r = new HashMap<>();
		r.put("token", token);
		return r;
	}

	// 从 cookie 中获取数据

	@ApiOperation(value = "test4")
	@ApiOperationSupport(order = 4)
	@GetMapping("/test4")
	public Map<String, Object> test4(@CookieValue String jSessionId) {
		Map<String, Object> r = new HashMap<>();
		r.put("jSessionId", jSessionId);
		return r;
	}

	// 获取到 Servlet 规范中的 request 和 response 对象

	@ApiOperation(value = "test5")
	@ApiOperationSupport(order = 5)
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

	@ApiOperation(value = "test6")
	@ApiOperationSupport(order = 6)
	@PostMapping("/test6")
	public Map<String, Object> test6(String name, @RequestParam Integer age, HttpServletRequest request) {
		Map<String, Object> r = new HashMap<>();
		r.put("Content-Type", request.getContentType());
		r.put("name", name);
		r.put("age", age);
		return r;
	}

	@ApiOperation(value = "test7")
	@ApiOperationSupport(order = 7)
	@PutMapping("/test7")
	public Map<String, Object> test7(Student student, HttpServletRequest request) {
		Map<String, Object> r = new HashMap<>();
		r.put("Content-Type", request.getContentType());
		r.put("student", student);
		return r;
	}

	// 从 HTTP 请求体中获取 multipart/form-data 类型的请求参数，用于文件上传

	@ApiOperation(value = "test8")
	@ApiOperationSupport(order = 8)
	@PostMapping("/test8")
	public Map<String, Object> test8(MultipartFile file, HttpServletRequest request) {
		Map<String, Object> r = new HashMap<>();
		r.put("Content-Type", request.getContentType());
		r.put("file", file.getOriginalFilename());
		return r;
	}

	// 从 HTTP 请求体中获取 application/json 类型的请求参数，用于传递 json 数据
	// 推荐使用

	@ApiOperation(value = "test9")
	@ApiOperationSupport(order = 9)
	@PostMapping("/test9")
	public Map<String, Object> test9(@RequestBody Student student, HttpServletRequest request) {
		Map<String, Object> r = new HashMap<>();
		r.put("Content-Type", request.getContentType());
		r.put("student", student);
		return r;
	}

	@ApiOperation(value = "test10")
	@ApiOperationSupport(order = 10)
	@PutMapping("/test10")
	public Map<String, Object> test10(@RequestBody Student student, HttpServletRequest request) {
		Map<String, Object> r = new HashMap<>();
		r.put("Content-Type", request.getContentType());
		r.put("student", student);
		return r;
	}

}
