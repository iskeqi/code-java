package com.keqi.client.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class SimpleChatClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {

        System.out.println(Thread.currentThread().getId() + " " + s);
        System.out.println(Thread.currentThread().getId() + " " + ctx.channel().id().asLongText());
    }
}
