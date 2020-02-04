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
 * 给定时任务配置线程池
 *
 * @author keqi
 */
@Configuration
@EnableScheduling // 必须加上此注解，否则定时任务不会开启
public class ScheduleConfiguration implements SchedulingConfigurer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleConfiguration.class);


	// 给ScheduledTaskRegistrar对象注入一个ThreadPoolTaskScheduler对象，就拥有了使用线程池来执行定时任务的能力
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setTaskScheduler(taskScheduler());
	}

	// 声明一个ThreadPoolTaskScheduler对象
	@Bean
	public ThreadPoolTaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		// 设定线程池大小
		taskScheduler.setPoolSize(4);
		taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
		// 设置线程名称前缀
		taskScheduler.setThreadNamePrefix("schedule");
		taskScheduler.setRemoveOnCancelPolicy(true);
		taskScheduler.setErrorHandler(t -> LOGGER.error("Error occurs", t));
		return taskScheduler;
	}
}

