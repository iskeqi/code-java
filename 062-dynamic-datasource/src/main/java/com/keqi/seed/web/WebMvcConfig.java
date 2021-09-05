package com.keqi.seed.web;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.keqi.seed.web.converter.MyStringToLocalDateConverter;
import com.keqi.seed.web.converter.MyStringToLocalDateTimeConverter;
import com.keqi.seed.web.converter.MyStringToNumberConverterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * web mvc 配置类
 * <p>
 * (
 * 如果希望对此类进行扩展，但是又无法直接更改此类时，可以创建一个配置类继承 WebMvcConfig 重写本类中已经重写
 * 的方法，还可以实现 WebMvcConfigurer 接口中在本类没有实现的方法
 * )
 *
 * @author keqi
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注册 web 拦截器
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] knife4jPaths = new String[]{
                "/doc.html",
                "/webjars/**",
                "/swagger-resources/**",
                "/swagger-ui.html/**",
                "/v2/api-docs",
                "/favicon.ico",
                "/error"
        };

        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
        // 注册Sa-Token的路由拦截器，并排除公开接口或其他可匿名访问的接口地址 (与注解拦截器无关)
        registry.addInterceptor(new SaRouteInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/sys/auth/login")
                .excludePathPatterns(knife4jPaths);
        // 注册 DynamicDatasourceInterceptor 拦截器，进行数据源的切换
        registry.addInterceptor(new DynamicDatasourceInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/sys/**") // sys/** 目录下的请求使用默认的 master 数据源
                .excludePathPatterns(knife4jPaths);
    }

    /**
     * 添加 Formatter 对象
     *
     * @param registry registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new MyStringToLocalDateConverter());
        registry.addConverter(new MyStringToLocalDateTimeConverter());
        registry.addConverterFactory(new MyStringToNumberConverterFactory());
    }

    /**
     * 替换掉 SpringBoot 默认配置的 MappingJackson2HttpMessageConverter 对象
     *
     * @return r
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        ObjectMapper objectMapper = new ObjectMapper();
        // 反序列化时，忽略掉不认识的属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        // Java8 日期时间处理(此处刻意不对 java.util.Date 做配置，程序中能不用这个类就不用)
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class,
                new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addSerializer(LocalDate.class,
                new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalTime.class,
                new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        javaTimeModule.addDeserializer(LocalDateTime.class,
                new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addDeserializer(LocalDate.class,
                new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addDeserializer(LocalTime.class,
                new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        objectMapper.registerModule(javaTimeModule);

        converter.setObjectMapper(objectMapper);
        return converter;
    }
}

