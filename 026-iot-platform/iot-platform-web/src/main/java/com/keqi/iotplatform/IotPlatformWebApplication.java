package com.keqi.iotplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.keqi.iotplatform.**.mapper")
public class IotPlatformWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotPlatformWebApplication.class, args);
	}

}
