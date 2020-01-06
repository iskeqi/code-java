package com.keqi.springbootconfigurationproperties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
// 这是前缀，和属性结合起来就是application.properties中的属性key值了
@ConfigurationProperties(prefix = "customer")
@Data
public class ConfigurationPropertiesEntity {

	private String username;

	private Integer password;

	private Boolean enable;

}
