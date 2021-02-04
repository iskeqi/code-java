package com.keqi.seed.core.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import com.keqi.seed.core.pojo.CoreConstant;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Knife4jConfig {

    @Autowired
    private OpenApiExtensionResolver openApiExtensionResolver;

    /**
     * 如果对项目中的接口进行分组，拷贝多份即可
     *
     * @return r
     */
    @Bean
    public Docket sys() {
        String groupName = "接口文档";
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false) // 关闭 swagger 默认响应状态码
                .groupName(groupName) // 指定模块名称
                .apiInfo(systemMangerInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(CoreConstant.ROOT_PACKAGE_NAME)) // 扫描指定包路径下的接口
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions(groupName));
    }

    private ApiInfo systemMangerInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("接口文档")
                .version("0.0.1")
                .build();
    }
}
