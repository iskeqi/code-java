package com.keqi.nettyserverhaier;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;
import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@RestController
public class DemoController {

    public static Channel channel;

    @GetMapping("/test1")
    public String test1() {

        CommandConsumerParam param = new CommandConsumerParam();
        param.setCommand("GetInEmptyPlate");
        param.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        param.setStation(String.valueOf(6));
        param.setStartingPoint(String.valueOf(1));
        param.setEndPoint(String.valueOf(2));

        String msg = JSON.toJSONString(param);

        DES des = SecureUtil.des(CommandConsumerEnum.DES_KEY.getCode().getBytes(StandardCharsets.UTF_8));
        msg = des.encryptBase64(msg, StandardCharsets.UTF_8);

        channel.writeAndFlush(msg);

        return msg;
    }

    @GetMapping("/test2")
    public String test2() {
        CommandConsumerParam param = new CommandConsumerParam();
        param.setCommand("SendBackEmptyPlate");
        param.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        param.setStation(String.valueOf(6));
        param.setStartingPoint(String.valueOf(1));
        param.setEndPoint(String.valueOf(2));

        String msg = JSON.toJSONString(param);

        DES des = SecureUtil.des(CommandConsumerEnum.DES_KEY.getCode().getBytes(StandardCharsets.UTF_8));
        msg = des.encryptBase64(msg, StandardCharsets.UTF_8);

        channel.writeAndFlush(msg);

        return msg;
    }

    @GetMapping("/test3")
    public String test3() {
        CommandConsumerParam param = new CommandConsumerParam();
        param.setCommand("GetInFullPlate");
        param.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        param.setStartingPoint(String.valueOf(1));
        param.setEndPoint(String.valueOf(2));

        String msg = JSON.toJSONString(param);

        DES des = SecureUtil.des(CommandConsumerEnum.DES_KEY.getCode().getBytes(StandardCharsets.UTF_8));
        msg = des.encryptBase64(msg, StandardCharsets.UTF_8);

        channel.writeAndFlush(msg);

        return msg;
    }

    @GetMapping("/test4")
    public String test4() {
        CommandConsumerParam param = new CommandConsumerParam();
        param.setCommand("SendOutFullPlate");
        param.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        param.setStartingPoint(String.valueOf(1));
        param.setEndPoint(String.valueOf(2));

        String msg = JSON.toJSONString(param);

        DES des = SecureUtil.des(CommandConsumerEnum.DES_KEY.getCode().getBytes(StandardCharsets.UTF_8));

        msg = des.encryptBase64(msg, StandardCharsets.UTF_8);

        channel.writeAndFlush(msg);

        return msg;
    }
}
