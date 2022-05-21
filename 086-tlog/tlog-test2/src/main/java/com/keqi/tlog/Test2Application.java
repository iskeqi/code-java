package com.keqi.tlog;

import com.yomahub.tlog.core.annotation.TLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@SpringBootApplication
public class Test2Application {

	public static void main(String[] args) {
		SpringApplication.run(Test2Application.class, args);
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
	@GetMapping("/demo2")
	public void demo(String id) {
		log.info(UUID.randomUUID().toString());
	}
}
