package com.keqi.springbootknife4j.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfiguration {

	@Bean
	public Docket systemManger() {

		// 这个全局处理参数已经过期，暂时还不清楚应该怎么修改（待定中...）

		// 全局响应状态码设置(默认已经有一个200的成功状态码，所以不需要设置)
		List<ResponseMessage> responseMessageList = new ArrayList<>();
		responseMessageList.add(new ResponseMessageBuilder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).build());
		responseMessageList.add(new ResponseMessageBuilder().code(HttpStatus.UNAUTHORIZED.value())
				.message(HttpStatus.UNAUTHORIZED.getReasonPhrase()).build());

		return new Docket(DocumentationType.SWAGGER_2)
				// 关闭默认的响应信息
				.useDefaultResponseMessages(false)
				// 设置GET请求全局的响应状态码
				.globalResponseMessage(RequestMethod.GET, responseMessageList)
				// 设置POST请求全局的响应状态码
				.globalResponseMessage(RequestMethod.POST, responseMessageList)
				.groupName("一、系统管理模块")
				.apiInfo(systemMangerInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.keqi.springbootknife4j.sys"))
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
	public Docket devManger() {

		// 全局响应状态码设置(默认已经有一个200的成功状态码，所以不需要设置)
		List<ResponseMessage> responseMessageList = new ArrayList<>();
		responseMessageList.add(new ResponseMessageBuilder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).build());
		responseMessageList.add(new ResponseMessageBuilder().code(HttpStatus.UNAUTHORIZED.value())
				.message(HttpStatus.UNAUTHORIZED.getReasonPhrase()).build());

		return new Docket(DocumentationType.SWAGGER_2)
				// 关闭默认的响应信息
				.useDefaultResponseMessages(false)
				// 设置GET请求全局的响应状态码
				.globalResponseMessage(RequestMethod.GET, responseMessageList)
				// 设置POST请求全局的响应状态码
				.globalResponseMessage(RequestMethod.POST, responseMessageList)
				.groupName("二、设备管理模块")
				.apiInfo(systemMangerInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.keqi.springbootknife4j.dev"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo systemMangerInfo() {
		return new ApiInfoBuilder()
				.title("knife4j")
				.description("knife4j使用示例")
				.termsOfServiceUrl("http://localhost:8333/")
				.version("1.0")
				.build();
	}

}
