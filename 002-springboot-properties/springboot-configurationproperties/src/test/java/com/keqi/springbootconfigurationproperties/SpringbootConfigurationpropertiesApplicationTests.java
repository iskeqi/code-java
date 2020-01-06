package com.keqi.springbootconfigurationproperties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootConfigurationpropertiesApplicationTests {

	@Autowired
	ConfigurationPropertiesEntity configurationPropertiesEntity;

	@Test
	void contextLoads() {
		String username = configurationPropertiesEntity.getUsername();

		Integer password = configurationPropertiesEntity.getPassword();

		Boolean enable = configurationPropertiesEntity.getEnable();
	}

}
