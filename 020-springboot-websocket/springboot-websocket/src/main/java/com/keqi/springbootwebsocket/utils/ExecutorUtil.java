package com.keqi.springbootwebsocket.utils;

import java.util.concurrent.*;

/**
 * 线程池工具类
 */
public class ExecutorUtil {

	// 线程池对象
	private static ExecutorService executorService;
	// 定时线程池对象
	private static ScheduledExecutorService scheduledExecutorService;

	// 两个线程池对象的初始化操作
	static {
		int minThreadNum = 5;
		int maxThreadNum = Runtime.getRuntime().availableProcessors();
		if(maxThreadNum < minThreadNum) minThreadNum = maxThreadNum;
		executorService = new ThreadPoolExecutor(minThreadNum, maxThreadNum, 60L,
				TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		scheduledExecutorService = Executors.newScheduledThreadPool(maxThreadNum);
	}

	/**
	 * 定时执行某个任务
	 * @param command 实现了Runnable接口的对象
	 * @param initialDelay 初始化延时，即调用了这个方法后，多长时间开始执行新的线程
	 * @param period 执行间隔时间，即前一次执行结束到下一次执行开始的时间间隔
	 * @param unit 时间单位
	 */
	public static void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit){
		scheduledExecutorService.scheduleAtFixedRate(command, initialDelay, period, unit);
	}

	/**
	 * 定时执行某个任务
	 * @param command 实现了Runnable接口的对象
	 * @param delay 延迟时间，即前一次执行开始到下一次执行开始的时间间隔
	 * @param unit 时间单位
	 */
	public static void schedule(Runnable command, long delay, TimeUnit unit) {
		scheduledExecutorService.schedule(command, delay, unit);
	}

	/**
	 * 丢一个实现了Runnable接口的对象进来，就会使用一个新的线程去执行它的run()方法
	 * @param task 实现了Runnable接口的对象
	 */
	public static void submit(Runnable task){
		executorService.submit(task);
	}

}



