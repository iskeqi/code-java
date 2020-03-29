package com.keqi.concurrentjavabasic.threadgroup;

public class Demo {

	public static void main(String[] args) {
		Thread testThread = new Thread(() -> {
			System.out.println("testThread 所属线程组名字:" + Thread.currentThread().getThreadGroup().getName());

			System.out.println("testThread 所属线程的名字：" + Thread.currentThread().getName());
		});

		testThread.start();;

		System.out.println("执行main方法的线程名字:" + Thread.currentThread().getName());
	}
}
