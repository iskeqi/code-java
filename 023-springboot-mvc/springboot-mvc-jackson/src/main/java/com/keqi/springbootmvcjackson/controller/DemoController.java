package com.keqi.springbootmvcjackson.controller;

import com.keqi.springbootmvcjackson.domain.Student;
import com.keqi.springbootmvcjackson.enums.GenderEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class DemoController {

	@GetMapping("/test1")
	public Student test1() {
		Student student = new Student();
		student.setName("keqi");
		student.setScore(new BigDecimal("85.1230000"));
		student.setGender(GenderEnum.MAN);
		return student;
	}

	@PostMapping("/test2")
	public Student test2(@RequestBody Student student) {
		return student;
	}
}
