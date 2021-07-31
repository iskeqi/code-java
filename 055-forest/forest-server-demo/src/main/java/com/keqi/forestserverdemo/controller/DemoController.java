package com.keqi.forestserverdemo.controller;

import com.keqi.forestserverdemo.response.ResultEntity;
import com.keqi.forestserverdemo.response.ResultEntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    private Environment environment;

    @GetMapping("/test1")
    public ResultEntity test1(String username, String password) {
        Map<String, Object> r = new HashMap<>();
        r.put("username", username);
        r.put("password", password);
        r.put("port", environment.getProperty("server.port"));
        double random = Math.random();
        if (random > 0.5) {
            return ResultEntityBuilder.success(r);
        } else if (random < 0.2) {
            return ResultEntityBuilder.failure("error");
        } else {
            if ("666666".equals(password)) {
                return ResultEntityBuilder.success(r);
            }
            return ResultEntityBuilder.noAuth("no auth");
        }
    }

    @PostMapping("/test2")
    public ResultEntity test2(@RequestBody Test2Dto test2Dto) {
        return ResultEntityBuilder.failure(test2Dto.toString());
    }
}
