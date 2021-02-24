package com.keqi.tdenginemybatisconnector;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.keqi.tdenginemybatisconnector.dao"})
@SpringBootApplication
public class TdengineMybatisConnectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TdengineMybatisConnectorApplication.class, args);
    }

}
