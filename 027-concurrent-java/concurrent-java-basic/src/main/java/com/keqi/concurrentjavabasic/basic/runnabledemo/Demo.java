package com.keqi.concurrentjavabasic.basic.runnabledemo;

/**
 * 测试实现 Runnable 接口实现的线程
 */
public class Demo {

	public static class MyThread implements Runnable {

		@Override
		public void run() {
			System.out.println("线程名称：" + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {

		System.out.println("线程名称：" + Thread.currentThread().getName());

		// 传统方式
		Thread thread = new Thread(new MyThread());
		thread.start();


		// 使用 java 8 的lambda表达式的方式
		/*new Thread(() -> System.out.println("线程名称：" + Thread.currentThread().getName())).start();*/
	}
}
