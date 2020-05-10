package com.keqi.concurrentjavabasic.communicate.semaphore;

import java.util.concurrent.Semaphore;

public class Work implements Runnable {

	private int workerNum; // 工人工号
	private Semaphore semaphore; // 机器数

	public Work(int workerNum, Semaphore semaphore) {
		this.workerNum = workerNum;
		this.semaphore = semaphore;
	}

	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		// 工人去获取机器

		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 打印工人获取到机器，开始工作

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() +" " + " ");
		// 线程睡眠1秒，模拟机器工作过程
		// 使用完毕，释放机器资源
		semaphore.release();
	}
}
