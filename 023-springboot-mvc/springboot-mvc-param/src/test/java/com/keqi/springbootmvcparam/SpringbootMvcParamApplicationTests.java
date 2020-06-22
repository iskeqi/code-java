package com.keqi.springbootmvcparam;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootTest
class SpringbootMvcParamApplicationTests {

	@Test
	void contextLoads() {
		HandlerMapping handlerMapping;
		DispatcherServlet dispatcherServlet;
		MultipartResolver multipartResolver;
		View view;
		ViewResolver viewResolver;
		WebMvcConfigurer webMvcConfigurer;
	}

}
