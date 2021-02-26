package com.keqi.springsecurityjwt.sys.controller;

import com.keqi.springsecurityjwt.core.response.ResultEntity;
import com.keqi.springsecurityjwt.core.response.ResultEntityBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/test1")
    public ResultEntity test1() {
        return ResultEntityBuilder.success();
    }
}
