package com.keqi.springbootmybatiscollection.controller;

import com.keqi.springbootmybatiscollection.mapper.SchoolMapper;
import com.keqi.springbootmybatiscollection.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {

	private final SchoolMapper schoolMapper;
	private final StudentMapper studentMapper;

	@GetMapping("/test1")
	public Object test1() {
		/*School one = this.schoolMapper.findOneById(1);

		School two = this.schoolMapper.getById(1);*/

		/*Student one = this.studentMapper.findOneById(1);

		Student two = this.studentMapper.getById(1);*/

		/*List<School> students = this.schoolMapper.getByIds(new Integer[]{1, 2, 3, 4});*/



		return null;
	}
}
