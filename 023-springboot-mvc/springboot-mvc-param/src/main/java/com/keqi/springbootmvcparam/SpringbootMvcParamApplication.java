package com.keqi.springbootmvcparam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@SpringBootApplication
public class  SpringbootMvcParamApplication {

	public static void main(String[] args) {
		RequestMappingHandlerAdapter requestMappingHandlerAdapter;
		SpringApplication.run(SpringbootMvcParamApplication.class, args);
	}

}
