package threadinterrupted;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public class InterruptTest {
	public static void main(String[] args) {
		testJoin();
	}

	private static void testJoin() {
		Thread t1 = new Thread(() -> {
			try {
				Thread.currentThread().join();
			} catch (InterruptedException e) {
				// 如果一个线程a 内部调用了 Thread类的 sleep() 方法，导致它处于 TIME_WAITING 状态时，
				// 线程b 调用了这个线程a 的 interrupt() 方法时，它就会抛出异常
				System.out.println("线程处于 TIME_WAITING 状态，但是 interrupt() 方法被调用了，故抛出异常");
				e.printStackTrace();
			}
		});
		t1.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
	}

	private static void testWait() {
		Thread t1 = new Thread(() -> {
			try {
				Thread.currentThread().wait();
			} catch (InterruptedException e) {
				// 如果一个线程a 内部调用了 Thread类的 sleep() 方法，导致它处于 TIME_WAITING 状态时，
				// 线程b 调用了这个线程a 的 interrupt() 方法时，它就会抛出异常
				System.out.println("线程处于 TIME_WAITING 状态，但是 interrupt() 方法被调用了，故抛出异常");
				e.printStackTrace();
			}
		});
		t1.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
	}

	private static void testSleep() {
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// 如果一个线程a 内部调用了 Thread类的 sleep() 方法，导致它处于 TIME_WAITING 状态时，
				// 线程b 调用了这个线程a 的 interrupt() 方法时，它就会抛出异常
				System.out.println("线程处于 TIME_WAITING 状态，但是 interrupt() 方法被调用了，故抛出异常");
				e.printStackTrace();
			}
		});
		t1.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
	}

	private static void test4() {
		System.out.println(Thread.interrupted()); // 输出为 false
		Thread.currentThread().interrupt(); // 将中断标志从 false 设置为 true
		Thread.currentThread().interrupt(); // 将中断标志从 false 设置为 true
		System.out.println(Thread.interrupted()); // 输出为 true,但是此时中断标志已经变成了false了
		System.out.println(Thread.currentThread().isInterrupted()); // 输出为 false
	}

	/**
	 * 通过 Thread 类的 stop() 方法停止线程
	 */
	private static void test2() {
		Thread t1 = new Thread(() -> {
			for (int i = 0; ; i++) {
				System.out.println(LocalTime.now().toString() + " " + i);
			}
		});
		t1.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("main线程：" + LocalTime.now().toString());
		t1.stop(); // 线程t1 立即就停止了
	}

	/**
	 * 通过 Thread 类的interrupt()方法发出中断通知（由 false 改成 true）
	 * 通过 Thread 类的isInterrupted()方法获取中断标志（判断是 false 还是 true）
	 */
	private static void test1() {
		Thread t1 = new Thread(() -> {
			for (int i = 0; ; i++) {
				System.out.println(LocalTime.now().toString() + " " + i);
				if (Thread.currentThread().isInterrupted()) {
					return; // 检测到终止状态为true，就自己主动结束线程
				}
			}
		});
		t1.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t1.interrupt(); // 设置 t1线程的终止状态为true（默认是false）
	}

	/**
	 * 使用 Thread 类的静态方法 interrupted() 方法（这个方法一般不用，但是如果中断标志为true时，希望改成false时，可以使用）
	 * 具体用法：
	 *      调用时，发现中断标志是 true，就会把中断标志就变成 false。
	 *      调用时，发现中断标志是 false，也会把中断标志设置为 false，但是相当于没有改变，因为它本来就是 false嘛。
	 */
	private static void test3() throws InterruptedException {
		AtomicInteger count = new AtomicInteger();
		Thread t1 = new Thread(() -> {
			for (int i = 0; ; i++) {
				// 如果中断标志本身就是 false ，那么Thread.interrupted()方法是不会改变中断状态的
				System.out.println(LocalTime.now().toString() + " " + i + " " + Thread.interrupted());
				if (Thread.currentThread().isInterrupted()) {
					if (count.get() >= 1) {
						System.out.println("线程t1要结束啦");
						return;
					}
					count.getAndIncrement();
					System.out.println("线程t1：" + Thread.interrupted()); // 检测到终止状态为true，就自己改为 false
				}
			}
		});
		t1.start();
		Thread.sleep(100);
		// 第一次设置中断标志
		t1.interrupt(); // 设置 t1线程的终止状态为true（默认是false）
		Thread.sleep(100);
		// 第二次设置中断标志
		t1.interrupt(); // 设置 t1线程的终止状态为true（默认是false）
	}
}
