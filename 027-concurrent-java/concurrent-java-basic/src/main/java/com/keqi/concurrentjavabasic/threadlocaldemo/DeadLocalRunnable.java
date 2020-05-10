package com.keqi.concurrentjavabasic.threadlocaldemo;

public class DeadLocalRunnable implements Runnable {

	private int flag; // 决定线程走向的一个标记

	private final static Object obj1 = new Object(); // 资源1
	private final static Object obj2 = new Object(); // 资源2

	public DeadLocalRunnable(int flag) {
		this.flag = flag;
	}


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
	@Override
	public void run() {
		if (flag == 1) {

			// 线程1执行代码
			synchronized (obj1) {
				System.out.println(Thread.currentThread().getName() + " 已经获取到 obj1，2s后请求 obj2");

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				synchronized (obj2) {
					System.out.println(Thread.currentThread().getName() + " obj1以及obj2都获取到了");
				}

			}

		} else {

			// 线程2执行代码
			synchronized (obj2) {
				System.out.println(Thread.currentThread().getName() + " 已经获取到 obj2，2s后请求 obj1");

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				synchronized (obj1) {
					System.out.println(Thread.currentThread().getName() + " obj1以及obj2都获取到了");
				}

			}

		}
	}
}
