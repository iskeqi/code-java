package com.keqi.userservice;

import com.keqi.userservice.config.PatternProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*@RefreshScope*/
@RestController
public class DemoController {

	/*
		配置实现热更新的两种方式：
			1、在使用了 @Value 注解属性所在的类上面，使用 @RefreshScope 注解
			2、使用 @ConfigurationProperties 注解将配置文件中的属性读取到实体类中(这种方式其实是更推荐的)
	 */

	/*
		多环境配置共享
			如果某个配置在开发、测试、生产都是一样的话，可以配置到同一个地方，且只配置一次

		微服务启动时，会从 nacos 读取多个配置文件：
			1、spring.application.name - spring.profiles.active.yml 例如：userservice-dev.yml
			2、spring.application.name.yml 例如：userservice.yml
				无论 profile 如何变化，这个文件一定会加载，因此多环境共享配置可以写入这个文件
	 */

	/*
		多种配置的优先级（某个配置key在多个环境中都存在相同的值时，哪个配置文件中的优先级最高呢？）：
			服务名-profile.yml > 服务名称.yml > 本地配置

			记忆方式：线上环境肯定大于本地环境，线上的指定环境的配置肯定大于通用配置
	 */


	@Resource
	private PatternProperties patternProperties;

	/*@Value("${pattern.dateformat}")
	private String dateformat;*/

	@GetMapping("/user/{id}")
	public User getById(@PathVariable Long id, @RequestHeader("X-Request-red") String header) {
		return new User(id, "keqi", header);
	}
}
