package com.keqi.seed.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Knife4j 配置类
 *
 * @author keqi
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {

	@Bean
	public Docket defaultApi2() {
		return new Docket(DocumentationType.SWAGGER_2)
				// 关闭默认的响应信息
				.useDefaultResponseMessages(false)
				.apiInfo(new ApiInfoBuilder()
						.description("RESTful APIs")
						.termsOfServiceUrl("http://www.keqi.com/")
						.version("1.0")
						.build())
				.groupName("2.X版本")
				.select()
				//这里指定Controller扫描包路径
				.apis(RequestHandlerSelectors.basePackage("com.keqi"))
				.paths(PathSelectors.any())
				.build();
	}
}
