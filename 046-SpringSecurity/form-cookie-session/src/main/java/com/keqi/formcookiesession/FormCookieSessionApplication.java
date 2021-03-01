package com.keqi.formcookiesession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FormCookieSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormCookieSessionApplication.class, args);
    }

    // @PreAuthorize("hasAuthority('test')")
    @PreAuthorize("hasRole('super_admin')")
    @GetMapping("/test")
    public String test() {

        System.out.println("test()");
        return "test";
    }
}
