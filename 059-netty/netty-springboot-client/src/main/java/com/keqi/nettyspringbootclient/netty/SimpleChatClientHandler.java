package com.keqi.nettyspringbootclient.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Objects;

public class SimpleChatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        boolean r = Objects.equals(s, ctx.channel().id().asLongText() + "\n");
        System.out.println(Thread.currentThread().getId() + " " + r + " " + s + " " + ctx.channel().id().asLongText());
    }

}
