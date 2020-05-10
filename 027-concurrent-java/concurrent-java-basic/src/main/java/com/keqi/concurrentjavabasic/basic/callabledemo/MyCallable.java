package com.keqi.concurrentjavabasic.basic.callabledemo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	/**
	 * Computes a result, or throws an exception if unable to do so.
	 *
	 * @return computed result
	 * @throws Exception if unable to compute a result
	 */
	@Override
	public String call() throws Exception {
		System.out.println("当前线程名称：" + Thread.currentThread().getName());
		return Thread.currentThread().getName();
	}
}
