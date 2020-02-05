package com.keqi.springbootrestclient.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * Spring Task  定时任务线程池配置
 */
@Configuration
@EnableScheduling
@Slf4j
public class SchedulerConfig implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		// 设定线程池大小
		taskScheduler.setPoolSize(10);
		taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
		// 设置线程名称前缀
		taskScheduler.setThreadNamePrefix("schedule");
		taskScheduler.setRemoveOnCancelPolicy(true);
		taskScheduler.setErrorHandler(t -> log.error("Error occurs", t));
		// 设置完属性后，这行代码不能少
		taskScheduler.initialize();

		scheduledTaskRegistrar.setTaskScheduler(taskScheduler);
	}
}
