package com.keqi.springbootenvironment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.Map;

@SpringBootTest
class SpringbootEnvironmentApplicationTests {

	@Autowired
	Environment environment;

	@Test
	void contextLoads() {
		/*
			通过Environment对象来获取配置文件中的属性
			getProperty() 方法好几个重载方法，如下：
				String getProperty(String key);
				String getProperty(String key, String defaultValue);
				<T> T getProperty(String key, Class<T> targetType);
				<T> T getProperty(String key, Class<T> targetType, T defaultValue);
		 */

		String username = environment.getProperty("customer.username");
		Integer password = environment.getProperty("customer.password", Integer.class);
		Boolean enable = environment.getProperty("customer.enable", Boolean.class);

		// 不知道为什么，这里的数组获取方式失败了，取出来的值是null ???
		String[] pets = environment.getProperty("pets", String[].class);
		String[] language = environment.getProperty("language", String[].class);

		Map friends = environment.getProperty("friends", Map.class);
		Map fri = environment.getProperty("fri", Map.class);

		Integer flag = environment.getProperty("flag", Integer.class);
		String uuid = environment.getProperty("uuid", String.class);
	}

}
