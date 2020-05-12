package com.keqi.concurrentjavabasic.poll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		ExecutorService executorService1 = Executors.newFixedThreadPool(100);

		ExecutorService executorService2 = Executors.newSingleThreadExecutor();

		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

		// 几个线程池必须要真正了解
	}
}
