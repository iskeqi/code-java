package com.keqi.springbootmybatis.controller;

import com.keqi.springbootmybatis.domain.User;
import com.keqi.springbootmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author keqi
 */
@RestController
public class UserController {

	@Autowired
	UserMapper userMapper;

	@GetMapping("/add1")
	@Transactional // 一般情况下这样用就够了
	public String adduser1() {
		for (int i = 0; i < 3; i++) {
			User u = new User();
			u.setCode("xx");
			userMapper.insertUser(u);
			if (i == 2) {
				throw new RuntimeException();
			}
		}
		return "success";
	}

	@GetMapping("/add2")
	@Transactional // 此时这个事务控制没有用了，因为它不管Checked Exception
	public String adduser2() throws Exception {
		for (int i = 0; i < 3; i++) {
			User u = new User();
			u.setCode("xx");
			userMapper.insertUser(u);
			if (i == 2) {
				throw new IOException();
			}
		}
		return "success";
	}


	@GetMapping("/add3")
	@Transactional(rollbackFor = Throwable.class)
	// 此时这个事务控制还是生效了，因为自己设置了rollbackFor的属性值为
	// 如果会抛出检查型异常，那就必须这么干
	public String adduser3() throws IOException {
		for (int i = 0; i < 3; i++) {
			User u = new User();
			u.setCode("xx");
			userMapper.insertUser(u);
			if (i == 2) {
				throw new IOException();
			}
		}
		return "success";
	}

}
