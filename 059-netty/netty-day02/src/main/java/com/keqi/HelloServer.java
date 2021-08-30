package com.keqi;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class HelloServer {

	public static void main(String[] args) {
		// 启动器，负责组装 netty 组件，启动服务器
		new ServerBootstrap()
				// BossEventLoop,WorkerEventLoop(selector, thread)
				.group(new NioEventLoopGroup())
				// 选择服务器的 ServerSocketChannel 实现
				.channel(NioServerSocketChannel.class)
				// boss 负责建立连接，worker 负责读写,决定 worker 能处理哪些事情
				.childHandler(
						// 代表和客户端进行数据读写的通道，
						new ChannelInitializer<NioSocketChannel>() {
					@Override
					protected void initChannel(NioSocketChannel ch) throws Exception {
						// 将接收到的字节数组转换成字符串
						ch.pipeline().addLast(new StringDecoder());
						// 自定义 handler
						ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
							@Override
							public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
								// 打印好上一步转换好的字符
								System.out.println(msg);
							}
						});
					}
				})
				// 绑定监听端口号
				.bind(8080);



	}
}
