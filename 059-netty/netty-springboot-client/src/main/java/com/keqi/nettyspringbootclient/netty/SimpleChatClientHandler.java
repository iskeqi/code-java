package com.keqi.nettyspringbootclient.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Objects;

public class SimpleChatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        Channel channel = ctx.channel();
        // 从 Map<Channel, String> 对象中根据 Channel 对象找到对应的远程服务器地址

        boolean r = Objects.equals(s, ctx.channel().id().asLongText() + "\n");
        System.out.println(Thread.currentThread().getName() + " " + r + " " + s + " " + ctx.channel().id().asLongText());
    }

}
