package com.keqi.springbootpropertysource;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

// 默认情况下，@PropertySource注解是不支持yml文件的读取的哦，需要自己进行扩展
@Configuration
// @PropertySource(value = "classpath:config/customer2.yml")
@Data
public class ConfigEntity3 {

	// @Value("${config2.customer.username}")
	private String username;

	// @Value("${config2.customer.password}")
	private String password;

}
