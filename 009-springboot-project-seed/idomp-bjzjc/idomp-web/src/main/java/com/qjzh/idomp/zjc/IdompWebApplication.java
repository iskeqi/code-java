package com.qjzh.idomp.zjc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@MapperScan("com.qjzh.idomp.zjc.**.mapper")
public class IdompWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdompWebApplication.class, args);
	}

}
