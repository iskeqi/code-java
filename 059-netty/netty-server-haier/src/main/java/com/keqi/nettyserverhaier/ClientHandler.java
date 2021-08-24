package com.keqi.nettyserverhaier;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;
import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        String ip = inetSocketAddress.getAddress().getHostAddress();
        int port = inetSocketAddress.getPort();

        DemoController.channel = ctx.channel();

        System.out.println("有一个新的客户端建立连接成功：" + ip + " -> " + port);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead() 接收到一条消息：" + msg);

        DES des = SecureUtil.des(CommandConsumerEnum.DES_KEY.getCode().getBytes(StandardCharsets.UTF_8));
        msg = des.decryptStr((String) msg, StandardCharsets.UTF_8);
        System.out.println(msg);

        CommandProducerParam param = JSON.parseObject((String) msg, CommandProducerParam.class);

        String command = param.getCommand();
        CommandProducerEnum commandProducerEnum = CommandProducerEnum.parseByCode(command);
        if (commandProducerEnum == null) {
            System.out.println("接收到错误指令：" + msg);
            return;
        }

        CommandProducerResp resp = new CommandProducerResp();
        resp.setId(param.getId());
        // resp.setResult(Math.random() > 0.5 ? "1" : "2");
        resp.setResult("1");
        String r = JSON.toJSONString(resp);

        Channel channel = ctx.channel();

        //
        String s = des.encryptBase64(r, StandardCharsets.UTF_8);
        channel.writeAndFlush(s);
        System.out.println("回复一条消息：" + s);
    }
}
