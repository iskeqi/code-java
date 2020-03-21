package com.keqi.springbootmybatistypehandler.config;

import com.keqi.springbootmybatistypehandler.converter.BaseEnumConverterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * 配置自定义类型转换器
	 *
	 * @param registry registry
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// 注册ConverterFactory(类型转换器工厂)
		registry.addConverterFactory(new BaseEnumConverterFactory());
	}
}
