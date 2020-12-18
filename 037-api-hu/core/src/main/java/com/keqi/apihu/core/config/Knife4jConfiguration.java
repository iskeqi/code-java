package com.keqi.apihu.core.config;

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
public class Knife4jConfiguration {

    /**
     * 如果对项目中的接口进行分组，拷贝多份即可
     *
     * @return r
     */
    @Bean
    public Docket sys() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false) // 关闭 swagger 默认响应状态码
                .groupName("一、系统管理模块") // 指定模块名称
                .apiInfo(systemMangerInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.keqi.knife4j.sys")) // 扫描指定包路径下的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo systemMangerInfo() {
        return new ApiInfoBuilder()
                .title("knife4j")
                .description("knife4j 项目接口文档")
                .termsOfServiceUrl("http://localhost:9090/knife4j")
                .version("1.0")
                .build();
    }
}
