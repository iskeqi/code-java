package com.keqi.springbootvalue;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 通过@Value注解获取yml中的配置
 */
@Data
@Configuration
public class ConfigEntity {

	@Value("${customer.username}")
	private String username;

	// 如果未在配置文件中获取到冒号前面对应的属性，那么久使用冒号后面的作为默认值替代
	@Value("${customer.password:123}")
	private Integer password;

	@Value("${customer.enable}")
	private Boolean enable;

	@Value("${flag}")
	private Integer flag;

	@Value("${uuid}")
	private String uuid;

	/*
	仍然无法获取到数组对应的值
	@Value("${pets}")
	private String[] pets;

	@Value("${languages}")
	private String[] languages;

	*/

	/*
	无法获取到Map类型的属性哦，还是应该通过key的方式获取
	@Value("${friends}")
	private Map<String, Object> friends;

	@Value("${fri}")
	private Map<String, Object> fri;

	*/


}
