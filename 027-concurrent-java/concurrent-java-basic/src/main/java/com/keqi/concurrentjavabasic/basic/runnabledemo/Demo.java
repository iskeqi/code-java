package com.keqi.concurrentjavabasic.basic.runnabledemo;

/**
 * 测试实现 Runnable 接口实现的线程
 */
public class Demo {

	public static class MyThread implements Runnable {

		@Override
		public void run() {
			System.out.println("My Thread");
		}
	}

	public static void main(String[] args) {
		// 传统方式
		new MyThread().run();



		// 使用 java 8 的lambda表达式的方式
		new Thread(() -> {
			System.out.println("My Thread");
		}).start();
	}
}
