package com.keqi.springbootmvctrain.controller;

import com.keqi.springbootmvctrain.domain.Teacher;
import com.keqi.springbootmvctrain.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ExceptionDemoController
 *
 * @author keqi
 */
@RestController
@RequestMapping("exceptionDemoController")
public class ExceptionDemoController {

	@GetMapping("/test1")
	public Teacher test1(boolean flag) {
		// 0 为 false ， 1 为 true
		if (flag) {
			throw new BusinessException("抛出自定义异常 BusinessException");
		}

		Teacher teacher = new Teacher();
		teacher.setAge(18);
		teacher.setBirthday(LocalDate.now());
		teacher.setCreateTime(LocalDateTime.now());
		return teacher;
	}

	@GetMapping("/test2")
	public Teacher test2(boolean flag) {
		// 0 为 false ， 1 为 true
		if (flag) {
			throw new RuntimeException("抛出异常 RuntimeException");
		}

		Teacher teacher = new Teacher();
		teacher.setAge(18);
		teacher.setBirthday(LocalDate.now());
		teacher.setCreateTime(LocalDateTime.now());
		return teacher;
	}
}
