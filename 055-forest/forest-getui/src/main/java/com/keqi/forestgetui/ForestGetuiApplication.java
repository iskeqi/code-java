package com.keqi.forestgetui;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@ForestScan
@SpringBootApplication
public class ForestGetuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForestGetuiApplication.class, args);
    }

}
