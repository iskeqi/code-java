package com.keqi;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class HelloClient {
	public static void main(String[] args) throws InterruptedException {
		// 创建启动器类
		new Bootstrap()
				.group(new NioEventLoopGroup())
				.channel(NioSocketChannel.class)
				.handler(new ChannelInitializer<NioSocketChannel>() {
					// 连接被简历后进行调用
					@Override
					protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {

					}
				})
				.connect("127.0.0.1", 8080)
				.sync()
				.channel()
				// 向服务器发送数据
				.writeAndFlush("hello world");
	}
}
