package com.keqi.springbootredispubsub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRedisPubsubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisPubsubApplication.class, args);
	}

	/*

		假设一个场景，需要等待异步回调结果，然后同步返回给前端。就可以利用这个机制实现


	 */
}
