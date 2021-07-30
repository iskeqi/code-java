package com.keqi.foreststudy;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@ForestScan
@SpringBootApplication
public class ForestStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForestStudyApplication.class, args);
    }

    /*
        Forest 使用非常的简单，真的只需要看看文档就行了。



     */
}
