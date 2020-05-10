package com.keqi.concurrentjavabasic.communicate.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreeThreadStartDemo {

	private CyclicBarrier cyclicBarrier = new CyclicBarrier(3); //

	public void startThree() {

		System.out.println("正在准备：" + Thread.currentThread().getName() + " " + System.currentTimeMillis());

		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

		System.out.println("已经启动了：" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
	}
}
