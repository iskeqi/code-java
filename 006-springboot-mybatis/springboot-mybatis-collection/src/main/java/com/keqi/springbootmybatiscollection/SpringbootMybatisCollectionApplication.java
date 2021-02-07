package com.keqi.springbootmybatiscollection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.keqi.springbootmybatisbase.sys.mapper")
@EnableTransactionManagement // 其实这个注解不写也可以
@SpringBootApplication
public class SpringbootMybatisCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisCollectionApplication.class, args);
    }

}
