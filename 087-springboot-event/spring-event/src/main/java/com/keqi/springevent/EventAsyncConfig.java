package com.keqi.springevent;

import org.springframework.aop.interceptor.AsyncExecutionAspectSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
public class EventAsyncConfig {

	public static final String TASK_CANCEL_ASYNC = "taskCancelAsync";

	@Bean(name = AsyncExecutionAspectSupport.DEFAULT_TASK_EXECUTOR_BEAN_NAME)
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		//核心线程池大小
		executor.setCorePoolSize(10);
		//最大线程数
		executor.setMaxPoolSize(20);
		//队列容量
		executor.setQueueCapacity(200);
		//活跃时间
		executor.setKeepAliveSeconds(60);
		//线程名字前缀
		executor.setThreadNamePrefix("defaultAsync-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return executor;
	}

	@Bean(name = TASK_CANCEL_ASYNC)
	public Executor taskCancelAsync() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		//核心线程池大小
		executor.setCorePoolSize(10);
		//最大线程数
		executor.setMaxPoolSize(20);
		//队列容量
		executor.setQueueCapacity(200);
		//活跃时间
		executor.setKeepAliveSeconds(60);
		//线程名字前缀
		executor.setThreadNamePrefix(TASK_CANCEL_ASYNC);
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return executor;
	}
}
