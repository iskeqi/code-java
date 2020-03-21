package com.keqi.springbootmybatistypehandler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.keqi.**.mapper")
@EnableTransactionManagement // 其实这个注解不写也可以
public class SpringbootMybatisTypehandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisTypehandlerApplication.class, args);
	}

}
