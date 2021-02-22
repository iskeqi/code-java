package com.keqi.seed;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		try {
			log.debug("API 文档地址：http://{}:9090/seed/doc.html", InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			log.debug(e.getMessage(), e);
		}
	}

}
