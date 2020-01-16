package com.keqi.fastjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private String name;

	private Integer age;

	private Double score;

	private List<Course> courseList;
}
