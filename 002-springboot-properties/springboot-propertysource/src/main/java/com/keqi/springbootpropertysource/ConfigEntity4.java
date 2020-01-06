package com.keqi.springbootpropertysource;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

// 默认情况下，@PropertySource注解是不支持yml文件的读取的哦，需要自己进行扩展
@Configuration
// @PropertySource(value = "classpath:config/customer2.yml")
// @ConfigurationProperties(prefix = "config2.customer")
@Data
public class ConfigEntity4 {

	private String username;

	private String password;

}
