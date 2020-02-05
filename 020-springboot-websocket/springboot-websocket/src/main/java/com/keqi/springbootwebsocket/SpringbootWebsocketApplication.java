package com.keqi.springbootwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootWebsocketApplication {

	/*
		总结：核心类就4个

		1) WebSocketSession类负责和客户端建立连接，接收消息，维护一个连接集合
		2) WebSocketContext类负责开启新线程，并把msgCode和WebSocketStrategy实现类组合在一起
		3) WebSocketClient类负责维护会话连接对象，并负责提供发送消息的方法
		4) PushThread类就是一个Runnable对象，维护WebSocketClient类和WebSocketStrategy类的组合
			负责调用WebSocketStrategy实现类发送消息
	 */

	// 心得：一开始不要想太多，先写一个最简单demo，然后再完善，这样思路就出来了，否则一开始就堵住了

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebsocketApplication.class, args);
	}

}
