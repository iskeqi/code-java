package com.keqi.springbootmvcparam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.http.converter.HttpMessageConverter;
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
		Resource resource;
		HttpMessageConverter httpMessageConverter;
		// Spring Bean 的生命周期
		BeanFactoryPostProcessor beanFactoryPostProcessor;

		InstantiationAwareBeanPostProcessor instantiationAwareBeanPostProcessor;
		BeanPostProcessor beanPostProcessor;

		BeanNameAware beanNameAware;
		BeanFactoryAware beanFactoryAware;
		ApplicationContextAware applicationContextAware;
		InitializingBean initializingBean;
		DisposableBean disposableBean;
		CommandLineRunner commandLineRunner;
		ApplicationRunner applicationRunner;


		InitDestroyAnnotationBeanPostProcessor initDestroyAnnotationBeanPostProcessor;
	}

}
