package com.keqi.springbootmybatismapperxml;

import com.keqi.springbootmybatismapperxml.domain.User;
import com.keqi.springbootmybatismapperxml.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@Test
	void selectUserByUsername() {
		User user = userMapper.selectUserByUsername("keqi");
		System.out.println(user);
	}

	@Test
	void singleMethodParam() {
		User user = userMapper.singleMethodParam("keqi");
		System.out.println(user);
	}

	@Test
	void singleEntityParam() {
		User u = new User();
		u.setUsername("keqi");
		User user = userMapper.singleEntityParam(u);
		System.out.println(user);
	}

	@Test
	void multiMethodParam() {
		User user = userMapper.multiMethodParam(3L,"keqi");
		System.out.println(user);
	}

	@Test
	void multiEntityParam() {
		User user1 = new User();
		user1.setId(3L);
		User user2 = new User();
		user2.setUsername("keqi");
		User user = userMapper.multiEntityParam(user1, user2);
		System.out.println(user);
	}

	@Test
	void listParam1() {
		List<User> userList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			User u = new User();
			u.setUsername("hjt");
			userList.add(u);
		}
		System.out.println(userMapper.listParam1(userList));
		userList.forEach(
				x -> System.out.println(x)
		);
	}

	@Test
	void listParam2() {
		List<User> userList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			User u = new User();
			u.setUsername("hjt");
			userList.add(u);
		}
		System.out.println(userMapper.listParam2(userList));
		userList.forEach(
				x -> System.out.println(x)
		);
	}

	@Test
	void setParam1() {
		Set<User> userSet = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			User u = new User();
			u.setUsername("hjt" + i);
			userSet.add(u);
		}
		System.out.println(userMapper.setParam1(userSet));
		userSet.forEach(
				x -> System.out.println(x)
		);
	}

	@Test
	void setParam2() {
		Set<User> userSet = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			User u = new User();
			u.setUsername("hjt" + i);
			userSet.add(u);
		}
		System.out.println(userMapper.setParam2(userSet));
		userSet.forEach(
				x -> System.out.println(x)
		);
	}

	@Test
	void arrayParam1() {
		User[] users = new User[5];
		for (int i = 0; i < 5; i++) {
			User u = new User();
			u.setUsername("hjt" + i);
			users[i] = u;
		}
		System.out.println(userMapper.arrayParam1(users));
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	void arrayParam2() {
		User[] users = new User[5];
		for (int i = 0; i < 5; i++) {
			User u = new User();
			u.setUsername("hjt" + i);
			users[i] = u;
		}
		System.out.println(userMapper.arrayParam2(users));
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	void dynamicIf() {
		//List<User> users = userMapper.dynamicIf("desc");
		List<User> users = userMapper.dynamicIf(null);
		users.forEach(
				x -> System.out.println(x)
		);
	}

	@Test
	void dynamicChoose() {
		List<User> users = userMapper.dynamicChoose("asc");
		//List<User> users = userMapper.dynamicChoose(null);
		users.forEach(
				x -> System.out.println(x)
		);
	}

	@Test
	void dynamicForeach() {
		List<User> userList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			User u = new User();
			u.setUsername("<foreach/>");
			userList.add(u);
		}
		System.out.println(userMapper.dynamicForeach(userList));
		userList.forEach(
				x -> System.out.println(x)
		);
	}

	@Test
	void dynamicWhere() {
		User user = userMapper.dynamicWhere(null, "hjt0000");
		System.out.println(user);
	}

	@Test
	void dynamicSet() {
		userMapper.dynamicSet(26L, "hjt0000");
	}

	@Test
	void dynamicTrim() {
		userMapper.dynamicTrim(26L, "hjt0000");
	}

}

