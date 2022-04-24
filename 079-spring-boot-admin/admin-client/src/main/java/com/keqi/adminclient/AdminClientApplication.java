package com.keqi.adminclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class AdminClientApplication {

	private static final Logger log = LoggerFactory.getLogger(AdminClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AdminClientApplication.class, args);
//		for (int i = 0; i < 1000; i++) {
//			log.info(UUID.randomUUID().toString());
//		}
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
		for (int i = 0; i < 10; i++) {
			scheduledExecutorService.scheduleWithFixedDelay(() -> {
				for (int i1 = 0; i1 < 100000; i1++) {
					log.info(UUID.randomUUID().toString());
				}
			}, 2, 5, TimeUnit.SECONDS);
		}
	}

}
