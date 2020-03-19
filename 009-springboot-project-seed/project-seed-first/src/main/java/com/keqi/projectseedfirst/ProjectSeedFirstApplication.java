package com.keqi.projectseedfirst;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.qjzh.idomp.zjc.**.mapper")
public class ProjectSeedFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSeedFirstApplication.class, args);
	}

}
