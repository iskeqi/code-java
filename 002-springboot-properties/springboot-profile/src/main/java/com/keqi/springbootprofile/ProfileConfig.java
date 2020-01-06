package com.keqi.springbootprofile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
public class ProfileConfig {

	@Value("${spring.profiles.active}")
	private String active;

	@Value("${gitee}")
	private String gitee;

	// IOC容器销毁此对象时，就会先调用此方法
	@PreDestroy
	public void destory() {
		System.out.println(active + " -> " + gitee);
	}

}
