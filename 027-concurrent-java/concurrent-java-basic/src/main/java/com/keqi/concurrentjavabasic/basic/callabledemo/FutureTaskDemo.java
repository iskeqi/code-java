package com.keqi.concurrentjavabasic.basic.callabledemo;

import java.util.concurrent.*;

public class FutureTaskDemo implements Callable<Integer> {

	/**
	 * Computes a result, or throws an exception if unable to do so.
	 *
	 * @return computed result
	 * @throws Exception if unable to compute a result
	 */
	@Override
	public Integer call() throws Exception {
		// 睡眠一秒钟
		Thread.sleep(1000);
		return 2;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		// 使用 FutureTask 类封装线程对象
		FutureTask<Integer> futureTask = new FutureTask<>(new Task());
		// 这里调用的实际上是Future<?> submit(Runnable task)方法，并直接使用FutrueTask的内置方法get()就能够得到返回值
		executorService.submit(futureTask);

		// 获取返回值
		System.out.println(futureTask.get());
	}
}
