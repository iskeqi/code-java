package com.keqi.concurrentjavabasic.communicate.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CoachRacerDemo {

	private CountDownLatch countDownLatch = new CountDownLatch(3);

	/**
	 * 运动员方法，由运动员线程调用
	 */
	public void racer() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " 运动员准备完毕");
		countDownLatch.countDown();
	}

	/**
	 * 教练方法，由教练线程调用
	 */
	public void coach() {
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("所有运动员准备完毕，教练可以开始训练了");
	}
}
