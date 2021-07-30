package com.keqi.foreststudy.controller;

import com.dtflys.forest.http.ForestResponse;
import com.keqi.foreststudy.forest.service.MyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class DemoController {

    @Autowired
    private MyClient myClient;

    @GetMapping("/hello")
    public String hello() {
        ForestResponse<String> response = myClient.getResponse();
        // 判断HTTP请求是否成功
        if (response.isSuccess()) {
            // HTTP请求成功后，还要进一步判断业务上是否成功
            String content = response.getContent();
            return content;
        }
        return "error";
    }

    @GetMapping("/test")
    public String test() {

        // HTTP 调用层面去检测调用成功还是失败就行，至于失败了之后应该怎么处理，是业务调用方的问题，不用业务场景解决方法也不一样
        AtomicBoolean success = new AtomicBoolean(false);
        String test = myClient.send("test", (data, request, response) -> {
            // 进行业务上的判断，
            System.out.println(response.getContent());
            success.set(true);
        }, (ex, request, response) -> {
            success.set(false);
            // 记录日志，补偿机制等
            System.out.println("error");
        });

        return success.get() ? "success" : "error";
    }
}
