package com.keqi.springboottask.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 给 Spring Task 配置线程池
 */
@Configuration
@EnableScheduling // 必须加上此注解，否则定时任务不会开启
public class ScheduleConfiguration implements SchedulingConfigurer {
	private static final Logger log = LoggerFactory.getLogger(ScheduleConfiguration.class);

	// 给ScheduledTaskRegistrar对象注入一个ThreadPoolTaskScheduler对象，就拥有了使用线程池来执行定时任务的能力
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();

		// ThreadPoolTaskScheduler对象核心配置
		taskScheduler.setPoolSize(4);
		taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
		taskScheduler.setThreadNamePrefix("schedule");
		taskScheduler.setRemoveOnCancelPolicy(true);
		taskScheduler.setErrorHandler(t -> log.error("Error occurs", t));
		taskScheduler.initialize(); // 这行代码不能少

		// 向 ScheduledTaskRegistrar 对象中注册 ThreadPoolTaskScheduler 对象
		taskRegistrar.setTaskScheduler(taskScheduler);
	}
}

