package com.keqi.c4;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

@Slf4j
public class Server {

	@SneakyThrows
	public static void main(String[] args) {
		Selector selector = Selector.open();
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false); // 设置成非阻塞模式

		// 建立 selector 和 channel 的联系（注册 channel）
		// SelectionKey 就是将来事件发生后，可以知道当前事件和哪个 channel 发生的事件
		SelectionKey sscKey = ssc.register(selector, 0, null);
		/*
			事件有4 种类型：
				accept：服务端会在有连接请求时出发
				connect: 客户端，在连接建立成功时触发
				read: 有可读数据时
				write：有可写数据时
		 */
		// key 只关注 accept 事件
		sscKey.interestOps(SelectionKey.OP_ACCEPT);


		ssc.bind(new InetSocketAddress(8080));
		while (true) {
			// select 方法(没有事件就阻塞，有事件才会恢复运行)
			selector.select();

			// 处理事件, 返回一个 set 集合，内部包含了所有发生的事件
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();

				ServerSocketChannel channel = (ServerSocketChannel) key.channel();
				SocketChannel sc = channel.accept();
				log.debug("accept {}" + sc.toString());

				if (key.isAcceptable()) {
					// 服务端 accept 有新的链接
				}

				if (key.isConnectable()) {

				}

				if (key.isReadable()) {
					// 可读事件
					// netty 实现
				}

				if (key.isWritable()) {

				}
				iterator.remove(); // key 处理完了，就必须要进行处理
			}

		}
	}
}
