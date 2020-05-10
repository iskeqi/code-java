package com.keqi.concurrentjavabasic.communicate.object;

public class Main {

	public static void main(String[] args) {
		OddEvenDemo oddEvenDemo = new OddEvenDemo();
		Thread thread1 = new Thread(() -> oddEvenDemo.odd());
		Thread thread2 = new Thread(() -> oddEvenDemo.event());
		thread1.start();
		thread2.start();
	}

}
