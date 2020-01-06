package com.keqi.springbootpropertysource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 注释：@ConfigurationProperties注解和@@PropertySource注解配合使用
 */
@Configuration
@PropertySource(value = "classpath:config/customer.properties")
@ConfigurationProperties(prefix = "config.customer")
@Data
public class ConfigEntity2 {


	private String username;

	private String password;

}
