package com.keqi.concurrentjavabasic.control.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAtomicDemo2 {

	private static AtomicInteger n = new AtomicInteger(0); // 使用原子类来解决非原子性操作
	private static CountDownLatch countDownLatch = new CountDownLatch(2);

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				// Thread.sleep(100);
				n.incrementAndGet();
			}
			countDownLatch.countDown();
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				// Thread.sleep(100);
				n.incrementAndGet();
			}
			countDownLatch.countDown();
		});

		thread1.start();
		thread2.start();
		countDownLatch.await();
		System.out.println("n 的最终值预期是2000，但是实际上的值则是：" + n);
	}

}
