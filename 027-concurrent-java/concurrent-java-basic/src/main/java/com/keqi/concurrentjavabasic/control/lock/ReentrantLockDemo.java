package com.keqi.concurrentjavabasic.control.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	public static void main(String[] args) {
		// synchronized 和 Lock 都是为了保证某一段代码的原子性

		// 锁又分为 不可重入锁，可重入锁，读写锁

		ReentrantLock lock = new ReentrantLock(); // 可重入锁

		for (int i = 0; i < 10; i++) {
			lock.lock();
			System.out.println("加锁次数:" + (i+1));
		}

		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("解锁次数：" + (i+1));
			} finally {
				lock.unlock();
			}
		}
	}
}
