package com.keqi.concurrentjavabasic.threadlocaldemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		DeadLocalRunnable runnable1 = new DeadLocalRunnable(1);
		DeadLocalRunnable runnable2 = new DeadLocalRunnable(2);

		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(runnable1);
		executorService.submit(runnable2);

	}
}
