package com.keqi.springbootmvcparam.controller.three;

import com.keqi.springbootmvcparam.common.AjaxEntity;
import com.keqi.springbootmvcparam.common.AjaxEntityBuilder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class Demo3Controller {

	@RequestMapping("/sys/requestMapping")
	public AjaxEntity requestMapping1() {
		return AjaxEntityBuilder.success();
	}

	@RequestMapping("/sys/ant/*")
	public AjaxEntity requestMapping2() {
		return AjaxEntityBuilder.success();
	}

	@RequestMapping("/sys/ant/?")
	public AjaxEntity requestMapping3() {
		return AjaxEntityBuilder.success();
	}

	@RequestMapping("/sys/ant/**")
	public AjaxEntity requestMapping4() {
		return AjaxEntityBuilder.success();
	}

	@GetMapping("/sys/get")
	public AjaxEntity get() {
		return AjaxEntityBuilder.success();
	}

	@PostMapping("/sys/post")
	public AjaxEntity post() {
		return AjaxEntityBuilder.success();
	}

	@PutMapping("/sys/put")
	public AjaxEntity put() {
		return AjaxEntityBuilder.success();
	}

	@DeleteMapping("/sys/delete")
	public AjaxEntity delete() {
		return AjaxEntityBuilder.success();
	}

	@GetMapping("/user/{userId}")
	public AjaxEntity pathVariable(@PathVariable String userId) {
		return AjaxEntityBuilder.success("userId", userId);
	}

	// url = "/user?username=123&password=123456"
	@GetMapping("/user/get1")
	public AjaxEntity get1(String username, String password) {
		return AjaxEntityBuilder.success();
	}

	@GetMapping("/user/get2")
	public AjaxEntity get2(@RequestParam String username, @RequestParam String password) {
		return AjaxEntityBuilder.success();
	}

	@GetMapping("/user/get3")
	public AjaxEntity get3(HttpServletRequest request, HttpServletResponse response) {
		return AjaxEntityBuilder.success();
	}

	@GetMapping("/user/cookie")
	public AjaxEntity cookie(@CookieValue("sessionId") String SessionId) {
		return AjaxEntityBuilder.success();
	}

	@GetMapping("/user/header")
	public AjaxEntity header(@RequestHeader("accessToken") String accessToken) {
		return AjaxEntityBuilder.success();
	}
}
