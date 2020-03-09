package com.keqi.spirngbootdictdb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@MapperScan("com.keqi.**.mapper")
public class SpirngbootDictDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpirngbootDictDbApplication.class, args);
	}

}
