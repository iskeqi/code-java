package com.keqi.concurrentjavabasic.basic.callabledemo;

import java.util.concurrent.*;

/**
 * 通过实现 Callable 接口实现线程
 */
public class Task implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// 睡眠一秒钟
		Thread.sleep(1000);
		return 2;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Task task = new Task();

		// 通过ExecutorService执行实现了Callable接口的线程对象
		Future<Integer> submit = executorService.submit(task);

		// 这里调用Future的get()方法会阻塞当前线程，直到得到结果
		// 所以，在实际编码过程中，建议使用可以设置超时时间的重载get方法。
		// 也就是这个重载方法哦：V get(long timeout, TimeUnit unit)
		Integer integer = submit.get();
		System.out.println(integer);
	}
}
