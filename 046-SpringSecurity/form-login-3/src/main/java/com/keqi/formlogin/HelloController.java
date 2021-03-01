package com.keqi.formlogin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 这个注解是支持使用 spel 表达式的
    //@PreAuthorize("principal.username.equals('admin')")
    // @PreAuthorize("hasAuthority('a')")
    // @PreAuthorize("hasAnyAuthority('a','b')")
    //@PreAuthorize("hasAnyRole('a','b')")
    //@PreAuthorize("hasRole('a')")

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
