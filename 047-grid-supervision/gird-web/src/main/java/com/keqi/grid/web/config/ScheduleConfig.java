package com.keqi.grid.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 给 Spring Task 配置线程池
 *
 * @author keqi
 */
@Configuration
@EnableScheduling
@Slf4j
public class ScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        // ThreadPoolTaskScheduler对象核心配置
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
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
