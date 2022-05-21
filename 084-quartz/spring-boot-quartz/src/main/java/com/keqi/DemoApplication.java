package com.keqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
		Quartz 设计模式
			Builder 模式
			工厂模式
			组件模式
				JobDetail
				Trigger
				Scheduler
			链式编程

		Quartz 的核心概念
			任务 JobDetail
			触发器 Trigger
				SimpleTrigger
				CronTrigger
			调度器 Scheduler
				start
				stop
				pause
				resume

		Quartz 常用的API
			Job
				每次调用时都会创建一个新的Job对象，用完之后就会丢弃
			JobDetail



















	 */
}
