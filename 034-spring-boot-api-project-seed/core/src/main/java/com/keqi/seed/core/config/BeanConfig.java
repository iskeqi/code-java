package com.keqi.seed.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 各种需要通过声明 Bean 对象的方式提交对象到 IOC 容器中的对象
 *
 * @author keqi
 */
@Configuration
public class BeanConfig {

	/**
	 * RestTemplate配置类(使用时，只需要从 IOC 容器中拿到 RestTemplate 对象即可)
	 *
	 * @return r
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
