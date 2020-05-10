package com.keqi.concurrentjavabasic.basic.callabledemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

	public static void main(String[] args) {
		FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
		Thread thread = new Thread(futureTask);
		thread.start();

		System.out.println("当前线程名称：" + Thread.currentThread().getName());
		String subThreadName = null;
		try {
			 subThreadName = futureTask.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("通过 FutureTask类的的 get() 方法获得的线程对象的返回值：" + subThreadName);
	}
}
