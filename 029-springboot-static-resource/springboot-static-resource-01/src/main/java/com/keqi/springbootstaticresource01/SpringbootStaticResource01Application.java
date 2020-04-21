package com.keqi.springbootstaticresource01;

import com.keqi.springbootstaticresource01.util.CommonUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

@SpringBootApplication
public class SpringbootStaticResource01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStaticResource01Application.class, args);
		System.out.println(CommonUtil.getApplicationHomeAbsolutePath());
	}

}
