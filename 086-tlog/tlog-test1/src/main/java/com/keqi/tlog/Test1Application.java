package com.keqi.tlog;

import com.dtflys.forest.springboot.annotation.ForestScan;
import com.yomahub.tlog.core.annotation.TLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ForestScan(basePackages = "com.keqi.tlog")
@RestController
@Slf4j
@SpringBootApplication
public class Test1Application {

	@Autowired
	private MyClient myClient;

	public static void main(String[] args) {
		SpringApplication.run(Test1Application.class, args);
//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		executorService.submit(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 100; i++) {
//					log.info(UUID.randomUUID().toString());
//				}
//			}
//		});
	}

	@TLogAspect({"id"})
	@GetMapping("/demo")
	public void demo(String id) {
		log.info(UUID.randomUUID().toString());
		myClient.helloForest(UUID.randomUUID().toString());
	}
}
