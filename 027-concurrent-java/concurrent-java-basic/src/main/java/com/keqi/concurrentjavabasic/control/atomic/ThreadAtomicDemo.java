package com.keqi.concurrentjavabasic.control.atomic;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

public class ThreadAtomicDemo {

	private static int n; // 执行 n++ 操作的变量（n++实际上并不是一个原子操作）
	private static CountDownLatch countDownLatch = new CountDownLatch(2);

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					// Thread.sleep(100);
					n++;
				}
				countDownLatch.countDown();
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@SneakyThrows
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					// Thread.sleep(100);
					n++;
				}
				countDownLatch.countDown();
			}
		});

		thread1.start();
		thread2.start();
		countDownLatch.await();
		System.out.println("n 的最终值预期是2000，但是实际上的值则是：" + n);
	}

}
