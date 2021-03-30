package com.keqi.springwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebsocketApplication.class, args);
	}

}
