package com.keqi.springbootmvcjackson.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.keqi.springbootmvcjackson.enums.BaseEnum;
import com.keqi.springbootmvcjackson.serialize.BaseEnumDeSerializer;
import com.keqi.springbootmvcjackson.serialize.BaseEnumSerializer;
import com.keqi.springbootmvcjackson.serialize.BigDecimalDeSerialize;
import com.keqi.springbootmvcjackson.serialize.BigDecimalSerialize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigDecimal;
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

		SimpleModule bigDecimalModule = new SimpleModule();
		bigDecimalModule.addSerializer(BigDecimal.class, new BigDecimalSerialize());
		bigDecimalModule.addDeserializer(BigDecimal.class, new BigDecimalDeSerialize());
		objectMapper.registerModule(bigDecimalModule);

		// 这种方式的缺点是只能支持 BaseEnum.clazz ，它的子类是不支持的
		SimpleModule baseEnumModule = new SimpleModule();
		baseEnumModule.addSerializer(BaseEnum.class, new BaseEnumSerializer<>());
		baseEnumModule.addDeserializer(BaseEnum.class, new BaseEnumDeSerializer());

		converter.setObjectMapper(objectMapper);
		return converter;
	}
}

