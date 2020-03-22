package com.keqi.projectseedsecond;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.keqi.projectseedsecond.**.mapper")
public class ProjectSeedSecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSeedSecondApplication.class, args);
	}

}
