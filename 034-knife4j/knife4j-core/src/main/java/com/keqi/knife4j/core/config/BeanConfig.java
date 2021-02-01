package com.keqi.knife4j.core.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 各种需要通过声明 Bean 对象的方式提交对象到 IOC 容器中的对象
 *
 * @author keqi
 */
@Configuration
public class BeanConfig {

	/**
	 * RestTemplate配置类(使用时，只需要从 IOC 容器中拿到 RestTemplate 对象即可)
	 *
	 * @return r
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * 使用表单提交参数和响应结果时，会调用此对象的方法对 LocalDate 类型的参数进行序列化和反序列化
	 *
	 * @return r
	 */
	@Bean("localDateFormatter")
	public Formatter<LocalDate> localDateFormatter() {
		return new Formatter<LocalDate>() {
			@Override
			public String print(LocalDate object, Locale locale) {
				return object.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}

			@Override
			public LocalDate parse(String text, Locale locale) {
				return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
		};
	}

	/**
	 * 使用表单提交参数和响应结果时，会调用此对象的方法对 LocalDateTime 类型的参数进行序列化和反序列化
	 *
	 * @return r
	 */
	@Bean("localDateTimeFormatter")
	public Formatter<LocalDateTime> localDateTimeFormatter() {
		return new Formatter<LocalDateTime>() {
			@Override
			public String print(LocalDateTime object, Locale locale) {
				return object.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			}

			@Override
			public LocalDateTime parse(String text, Locale locale) {
				return LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			}
		};
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

		// Java8 日期时间处理(此处刻意不对 LocalTime 和 Date 做配置，程序中能不用这两个类就不用)
		JavaTimeModule javaTimeModule = new JavaTimeModule();

		javaTimeModule.addSerializer(LocalDateTime.class,
				new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		javaTimeModule.addSerializer(LocalDate.class,
				new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

		javaTimeModule.addDeserializer(LocalDateTime.class,
				new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		javaTimeModule.addDeserializer(LocalDate.class,
				new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

		objectMapper.registerModule(javaTimeModule);

		converter.setObjectMapper(objectMapper);
		return converter;
	}
}