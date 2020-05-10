package com.keqi.concurrentjavabasic.safe;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		SafeDemo safeDemo = new SafeDemo();
		Thread thread = new Thread(safeDemo);
		thread.start();

		Thread thread1 = new Thread(safeDemo);
		thread1.start();

		ReentrantLock reentrantLock;
	}
}
