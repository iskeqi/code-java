package com.keqi.springbootmvcstaticresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootMvcStaticResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMvcStaticResourceApplication.class, args);
    }

    @GetMapping("/index")
    public String index() {


        return "bbb";
    }

}
