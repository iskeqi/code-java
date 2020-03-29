package com.keqi.hutool.core;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterUserParam {

	private String name;

	private String phone;

	private String eamil;

	private Integer age;

	private Double score;

	private LocalDate birthday;

}
