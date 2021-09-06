package com.keqi.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface UserClient {

	/*
		openfeign 有默认的配置，但是很多东西是可以修改的，比如：

			1、feign.Logger.Level 修改日志级别：默认 NONE, 还有 BASIC、HEADERS、FULL
			2、feign.codec.Decoder 响应结果的解析器：http远程调用的结果做解析，比如解析 json 字符串为 java 对象
			3、feign.codec.Encoder 请求参数编码：将请求参数编码，便于通过 http 请求发送
			4、feign.Contract 支持的注解格式，默认是 SpringMVC 的注解
			5、feign.Retryer 失败重置机制：默认不会进行重试，不过会使用Ribbon的重试

		一般我们需要配置的的就是日志级别

			基于配置文件：
				feign.client.config.default.loggerLevel:FULL 针对全局进行配置
				fiegn.client.config.user-service.loggerLevel:FULL 只在调用 user-service 服务时，此配置才生效

			基于 Java 代码进行配置
				步骤一：进行如下配置：
					@Bean
					public Logger.Level logLevel() {
						return Logger.Level.BASIC;
					}
				步骤二：
					方法一：（全局配置）
						@EnableFeignClinets(defaultConfiguration = FeignClientConfiguration.class)

					方法二：（针对单个 @FeignClient修饰的接口有效）
						@FeignClient(value = "user-service", configuration = FeignClientConfiguration.class)
	 */

	/*
		对于 Feign 的使用，了解即可，毕竟现在都已经 2021.9 了，直接使用 spring cloud alibaba 的 dubbo spring cloud 不香吗？

	 */

	/*
		Feign 的最佳实践
			方法一：（耦合严重，在方法中的参数无法继承）
				给消费者的 FeignCliet 和提供者的 controller 定义统一的父接口作为标准
					其实内部开发的微服务，直接使用由服务提供者去维护接口就行

			方法二：（服务提供者来进行维护，最为推荐）
				将 feignClient 抽取为独立模块，并且把接口有关的 pojo ，默认的 feign 配置都放到这个模块中，提供给所有消费者
	 */


	@GetMapping("/user/{id}")
	User findById(@PathVariable Long id);
}
