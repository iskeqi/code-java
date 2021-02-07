package com.keqi.springbootmybatisbase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.keqi.springbootmybatisbase.sys.mapper")
@SpringBootApplication
public class SpringbootMybatisBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisBaseApplication.class, args);
    }

}
