package com.keqi.springevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TaskEventListener {

	/*
		默认情况下是在发布事件的线程中,进行同步调用。但是也支持配置多个线程池,并使用@Async注解进行异步处理

		线程池类型为 ThreadPoolTaskExecutor ,实际上就是对 JDK ThreadPoolExecutor 的进一步封装

		SpringTask 中的通过配置 ThreadPoolTaskScheduler 来实现线程池执行定时任务
		在没有指定线程池和配置默认线程池时,这个线程池也可以为作为 @Async 的线程池使用
	 */


	@Async // 找到默认线程池进行处理
	@EventListener
	public void taskCancelEventListener(TaskCancelEvent taskCancelEvent) {
		log.info("taskCancelEventListener do something...");
	}

	@Async(EventAsyncConfig.TASK_CANCEL_ASYNC) // 指定线程池执行
	@EventListener
	public void taskHangEventListener(TaskHangEvent taskHangEvent) {
		log.info("taskHangEventListener do something...");
	}
}
