package lockdemo;

public class synchronizedObjectLock {
	public static void main(String[] args) throws InterruptedException {
		test1();
	}

	private static void test1() throws InterruptedException {
		Object obj = new Object();
		Thread t1 = new Thread(() -> {
			synchronized (obj) {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " " + i);
				}
			}
 		}, "t1");
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		}, "t2");

		t1.start();
		Thread.sleep(100); // 这一步是为了让t1先执行，因为线程的具体执行是操作系统决定的
		t2.start();
	}
}
