package com.keqi.apihu.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置类(使用时，只需要从 IOC 容器中拿到 RestTemplate 对象即可)
 *
 * @author keqi
 */
@Configuration
public class RestTemplateConfig {

    /**
     * 底层使用的是 JDK 中的 HttpUrlConnection 对象
     *
     * @return r
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
