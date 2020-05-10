package com.keqi.concurrentjavabasic.communicate.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenDemo {

	private int i = 0; // 要打印的数

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();


	/**
	 * 奇数打印方法，由奇数打印方法
	 */
	public void odd() {
		while (i < 10) {
			lock.lock();
			try {

				if (i % 2 == 1) {
					System.out.println("奇数：" + i);
					i++;
					condition.signal(); // 唤醒其它线程打印
				} else {
					try {
						condition.await(); // 等待偶数线程打印完毕
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} finally {
				lock.unlock();
			}

		}
	}

	/**
	 * 偶数打印方法，由偶数线程调用
	 */
	public void event() {
		while (i < 10) {
			lock.lock();
			try {
				if (i % 2 == 0) {
					System.out.println("偶数：" + i);
					i++;
					condition.signal(); // 唤醒其它线程打印
				} else {
					try {
						condition.await(); // 等待偶数线程打印完毕
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} finally {
				lock.unlock();
			}
		}
	}
}
