package com.keqi.knife4j;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication.run(Application.class, args);
		log.debug("API 文档地址：http://{}:9090/knife4j/doc.html", InetAddress.getLocalHost().getHostAddress());
	}

}
