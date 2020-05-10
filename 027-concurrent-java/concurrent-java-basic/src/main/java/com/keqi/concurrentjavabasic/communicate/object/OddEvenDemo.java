package com.keqi.concurrentjavabasic.communicate.object;

public class OddEvenDemo {

	private int i = 0; // 要打印的数

	private Object obj = new Object();


	/**
	 * 奇数打印方法，由奇数打印方法
	 */
	public void odd() {
		while (i < 10) {
			synchronized (obj) {
				if (i % 2 == 1) {
					System.out.println("奇数：" + i);
					i++;
					obj.notify(); // 唤醒其它线程打印
				} else {
					try {
						obj.wait(); // 等待偶数线程打印完毕
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 偶数打印方法，由偶数线程调用
	 */
	public void event() {
		while (i < 10) {
			synchronized (obj) {
				if (i % 2 == 0) {
					System.out.println("偶数：" + i);
					i++;
					obj.notify(); // 唤醒其它线程打印
				} else {
					try {
						obj.wait(); // 等待偶数线程打印完毕
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
