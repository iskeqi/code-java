package com.keqi.springbootmybatismapperxml;

import com.keqi.springbootmybatismapperxml.domain.User;
import com.keqi.springbootmybatismapperxml.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisMapperXmlApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Test
	void insertUser() {
		User user = new User();
		user.setUsername("user1");
		userMapper.insertUser(user);
	}

	@Test
	void deleteUserById() {
		userMapper.deleteUserById(1L);
	}

	@Test
	void updateUserById() {
		User user = new User();
		user.setId(2L);
		user.setUsername("keqi");
		userMapper.updateUserById(user);
	}

	@Test
	void selectUserById() {
		User user = userMapper.selectUserById(2L);
		System.out.println(user);
	}

}

