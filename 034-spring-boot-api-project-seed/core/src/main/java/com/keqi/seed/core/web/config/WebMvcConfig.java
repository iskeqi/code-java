package com.keqi.seed.core.web.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.keqi.seed.core.web.converter.MyStringToLocalDateConverter;
import com.keqi.seed.core.web.converter.MyStringToLocalDateTimeConverter;
import com.keqi.seed.core.web.converter.MyStringToNumberConverterFactory;
import com.keqi.seed.core.web.interceptor.SecurityInterceptor;
import com.keqi.seed.core.pojo.CoreConstant;
import com.keqi.seed.core.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * web mvc 配置类
 *
 * @author keqi
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private SecurityInterceptor securityInterceptor;

    /**
     * 注册拦截器对象
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册一个安全拦截器，拦截所有请求（登录接口及 knife4j 的UI界面接口除外）
        String[] knife4jPaths = new String[]{
                "/doc.html",
                "/webjars/**",
                "/swagger-resources/**",
                "/swagger-ui.html/**",
                "/v2/api-docs",
                "/favicon.ico",
                "/error"
        };

        registry.addInterceptor(securityInterceptor).addPathPatterns("/**")
                // 放行 knife4j 路径
                .excludePathPatterns(knife4jPaths)
                // 放行登录接口请求路径
                .excludePathPatterns("/sys/auth/login")
                // 放行公开文件请求路径
                .excludePathPatterns("/publicFile/**");
    }

    /**
     * 跨域配置
     *
     * @param registry registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    /**
     * 添加静态资源映射路径（不会影响到默认的 4 个静态资源映射）
     *
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置对外公开的文件映射路径
        String filePath = "file:" + CommonUtil.getApplicationHomeAbsolutePath() + CoreConstant.UPLOAD_FILE_PUBLIC_FILE;
        registry.addResourceHandler("/publicFile/**").addResourceLocations(filePath);
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

