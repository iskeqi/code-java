package com.keqi.bestpracticeone.sys.controller;

import com.keqi.bestpracticeone.core.response.ResultEntity;
import com.keqi.bestpracticeone.core.response.ResultEntityBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/dictItem")
public class DictItemController {

    @GetMapping("/list")
    public ResultEntity list() {
//        NullPointerException p = new NullPointerException();
//
//        return ResultEntityBuilder.failure(p);
        return ResultEntityBuilder.success();
    }
}
