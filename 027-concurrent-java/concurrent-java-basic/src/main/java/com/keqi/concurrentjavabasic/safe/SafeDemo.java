package com.keqi.concurrentjavabasic.safe;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

public class SafeDemo implements Runnable {

	private int num = 100;

	private final ReentrantLock reentrantLock = new ReentrantLock(true);

	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see Thread#run()
	 */
	@SneakyThrows
	@Override
	public void run() {
		reentrantLock.lock();
		try {
			while (true) {
				Thread.sleep(100);
				if (num > 0 ) {
					System.out.println(Thread.currentThread().getName() + " " + num--);
				} else {
					return;
				}
				Thread.sleep(100);
			}
		} finally {
			reentrantLock.unlock();
		}
	}

}
