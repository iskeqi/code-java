package com.keqi.springbootmybatismapperxml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.keqi.springbootmybatisbase.sys.mapper")
@EnableTransactionManagement // 其实这个注解不写也可以
public class SpringbootMybatisMapperXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisMapperXmlApplication.class, args);
	}

}
