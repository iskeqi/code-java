package com.keqi.c4;

import lombok.SneakyThrows;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {

	@SneakyThrows
	public static void main(String[] args) {

		SocketChannel sc = SocketChannel.open();
		sc.connect(new InetSocketAddress("localhost", 8080));
		System.out.println("waiting...");


	}
}
