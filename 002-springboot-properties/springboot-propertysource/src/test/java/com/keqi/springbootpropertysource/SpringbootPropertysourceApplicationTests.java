package com.keqi.springbootpropertysource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootPropertysourceApplicationTests {

	@Autowired
	ConfigEntity1 configEntity1;

	@Autowired
	ConfigEntity2 configEntity2;


	@Test
	void contextLoads() {

		String username = configEntity1.getUsername();
		String password = configEntity1.getPassword();

		String username1 = configEntity2.getUsername();
		String password1 = configEntity2.getPassword();

	}

}
