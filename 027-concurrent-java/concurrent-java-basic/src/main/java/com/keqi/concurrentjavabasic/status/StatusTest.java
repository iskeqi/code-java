package com.keqi.concurrentjavabasic.status;

public class StatusTest {
	public static void main(String[] args) throws InterruptedException {
		testStartMethod();
	}

	public static void testStartMethod() throws InterruptedException {
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(1000*100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println(thread.getState());
		thread.start(); // 第一次调用
		System.out.println(thread.getState());
		// thread.start(); // 第二次调用(会抛出异常)
		// thread.wait();
		System.out.println(thread.getState());
	}
}
