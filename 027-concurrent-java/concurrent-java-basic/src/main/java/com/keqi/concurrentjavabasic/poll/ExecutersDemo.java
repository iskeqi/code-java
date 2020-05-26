package com.keqi.concurrentjavabasic.poll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutersDemo {

	public static void main(String[] args) {
		/*ExecutorService executorService = Executors.newFixedThreadPool(100);

		executorService.execute(() -> System.out.println(Thread.currentThread().getName()));*/
		ExecutorService executorService = Executors.newCachedThreadPool();

	}
}
