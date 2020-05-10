package com.keqi.concurrentjavabasic.communicate.cyclicBarrier;

public class Main {
	public static void main(String[] args) {
		ThreeThreadStartDemo threeThreadStartDemo = new ThreeThreadStartDemo();
		Thread thread1 = new Thread(() -> threeThreadStartDemo.startThree());
		Thread thread2 = new Thread(() -> threeThreadStartDemo.startThree());
		Thread thread3 = new Thread(() -> threeThreadStartDemo.startThree());

		thread1.start();
		thread2.start();
		// 如果下面这行代码不执行，那么上面两个线程将一直处于阻塞状态
		// thread3.start();
	}
}
