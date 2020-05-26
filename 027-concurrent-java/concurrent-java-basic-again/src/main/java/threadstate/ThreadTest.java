package threadstate;

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		ThreadTest threadTest = new ThreadTest();
		threadTest.test2();
	}

	// 直接使用 join() 方法
	public void test2() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			System.out.println("t1开始执行");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t1结束执行");
		});
		t1.start();

		System.out.println("main线程开始等待");
		t1.join();
		System.out.println("main线程等待结束");
	}

	// 简单模拟 join() 方法的实现
	public void test1() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			System.out.println("t1开始执行");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t1结束执行");
		});
		t1.start();

		System.out.println("main线程开始等待");
		do {
		} while (t1.isAlive());
		System.out.println("main线程等待结束");
	}
}
