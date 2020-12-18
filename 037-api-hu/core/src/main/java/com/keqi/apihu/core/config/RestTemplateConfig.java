package com.keqi.apihu.core.config;

import lombok.AllArgsConstructor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置类(使用时，只需要从 IOC 容器中拿到 RestTemplate 对象即可)
 *
 * @author keqi
 */
@Configuration
@AllArgsConstructor
public class RestTemplateConfig {

    private final CloseableHttpClient httpClient;

    @Bean
    public RestTemplate restTemplate() {
        // 为RestTemplate对象注入HttpComponentsClientHttpRequestFactory对象
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
                new HttpComponentsClientHttpRequestFactory();
        // 为HttpComponentsClientHttpRequestFactory对象设置CloseableHttpClient对象
        clientHttpRequestFactory.setHttpClient(httpClient);
        return new RestTemplate(clientHttpRequestFactory);
    }

}
