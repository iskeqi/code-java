package com.keqi.concurrentjavabasic.basic.threaddemo;

/**
 * 继承 Thread 类的方法编写线程
 */
public class Demo {

	public static class MyThread extends Thread {

		@Override
		public void run() {
			System.out.println("My Thread");
		}
	}

	public static void main(String[] args) {
		Thread myThread = new MyThread();

		// 开启线程，此时仅仅是处于就绪状态，等到该线程得到cpu时间片时，才会调用该线程
		// 的run() 方法，开启线程
		myThread.start();
	}

}
