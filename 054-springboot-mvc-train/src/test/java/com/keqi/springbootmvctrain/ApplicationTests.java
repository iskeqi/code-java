package com.keqi.springbootmvctrain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {

		BeanDefinitionReader beanDefinitionReader;

		BeanDefinition beanDefinition;

		BeanFactoryPostProcessor beanFactoryPostProcessor;

		BeanFactory beanFactory;

		BeanPostProcessor beanPostProcessor;

		// Feign 中就是采用了这个功能实现的对象个性化修改
		FactoryBean<?> factoryBean;

		Environment environment;

		ClassPathXmlApplicationContext classPathXmlApplicationContext;
	}

}
