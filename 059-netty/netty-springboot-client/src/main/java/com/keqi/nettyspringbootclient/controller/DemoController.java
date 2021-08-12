package com.keqi.nettyspringbootclient.controller;

import com.keqi.nettyspringbootclient.init.UpperComputerRunner;
import io.netty.channel.Channel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoController {

    @GetMapping("/test1")
    public String test1(String str) {
        for (Map.Entry<String, Channel> entry : UpperComputerRunner.CHANNEL_MAP.entrySet()) {
            Channel value = entry.getValue();
            value.writeAndFlush(str);
        }
        return "success";
    }
}
