package com.keqi.knife4j.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 给 Spring Task 配置线程池（如果系统中对定时任务的需求不大，使用 Spring Task 即可）
 *
 * @author keqi
 */
@Configuration
@EnableScheduling // 必须加上此注解，否则定时任务不会开启
@Slf4j
public class ScheduleConfiguration implements SchedulingConfigurer {

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
