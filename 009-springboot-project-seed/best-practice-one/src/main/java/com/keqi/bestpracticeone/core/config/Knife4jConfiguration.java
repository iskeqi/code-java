package com.keqi.bestpracticeone.core.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@AllArgsConstructor
public class Knife4jConfiguration {

    @Bean
    public Docket sys() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName("一、系统管理模块")
                .apiInfo(systemMangerInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.keqi.bestpracticeone.sys"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo systemMangerInfo() {
        return new ApiInfoBuilder()
                .title("BEST-PRACTICE-ONE")
                .description("BEST-PRACTICE-ONE 项目模板")
                .termsOfServiceUrl("http://localhost:9090/best-practice-one")
                .version("1.0")
                .build();
    }
}
