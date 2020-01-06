package com.keqi.springbootpropertysource;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 注释：@Value注解和@@PropertySource注解配合使用
 */
@Configuration
@PropertySource(value = "classpath:config/customer.properties")
@Data
public class ConfigEntity1 {

	@Value("${config.customer.username}")
	private String username;

	@Value("${config.customer.password}")
	private String password;

}
