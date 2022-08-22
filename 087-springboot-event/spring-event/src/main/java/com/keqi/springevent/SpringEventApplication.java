package com.keqi.springevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class SpringEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEventApplication.class, args);
	}

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping("/test1")
	public void test1() {
		TaskCancelEvent taskCancelEvent = new TaskCancelEvent(new Object(), "12");
		log.info("publishEvent {}", taskCancelEvent);
		publisher.publishEvent(taskCancelEvent);
	}

	@GetMapping("/test2")
	public void test2() {
		TaskHangEvent taskHangEvent = new TaskHangEvent(new Object(), "13");
		log.info("publishEvent {}", taskHangEvent);
		publisher.publishEvent(taskHangEvent);
	}
}
