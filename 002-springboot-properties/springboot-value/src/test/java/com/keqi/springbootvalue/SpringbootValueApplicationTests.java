package com.keqi.springbootvalue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootValueApplicationTests {

	@Autowired
	ConfigEntity configEntity;

	@Test
	void contextLoads() {

		String username = configEntity.getUsername();
		Integer password = configEntity.getPassword();
		Boolean enable = configEntity.getEnable();

		Integer flag = configEntity.getFlag();

		String uuid = configEntity.getUuid();


	}
}
