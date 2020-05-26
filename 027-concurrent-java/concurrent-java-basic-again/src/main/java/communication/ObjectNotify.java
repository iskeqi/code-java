package communication;

/**
 * 测试使用 Object 类的 notify()/notifyAll()/wait() 方法来实现你一口我一口的那种效果
 */
public class ObjectNotify {
	public static void main(String[] args) throws InterruptedException {
		test1();
	}

	/**
	 * 本方法达到的效果就是，t1 t2 线程之间，你一口我一口的一直运行下去，每次输出3次，就结束
	 * 这种你一口我一口的模型，的确支持3个及以上的线程执行，但是并不会均匀的分配，因为这是随机的。
	 * 所以，仍然建议只有两个线程交替运行的场景下，采用这种方式编码。
	 * @throws InterruptedException InterruptedException
	 */
	private static void test1() throws InterruptedException {
		Object obj = new Object();
		Thread t1 = new Thread(() -> {
			synchronized (obj) {
				while (true) {
					// 执行3次
					for (int i = 0; i < 3; i++) {
						System.out.println(Thread.currentThread().getName() + " " + i);
					}
					obj.notify(); // 随机通知正在等待这个对象锁的多个线程中的一个
					try {
						obj.wait(); // 让自己处于无限等待状态 WAITING，释放当前的锁
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "t1");

		Thread t2 = new Thread(() -> {
			synchronized (obj) {
				while (true) {
					// 执行3次
					for (int i = 0; i < 3; i++) {
						System.out.println(Thread.currentThread().getName() + " " + i);
					}
					obj.notify(); // 随机通知正在等待这个对象锁的多个线程中的一个
					try {
						obj.wait(); // 让自己处于无限等待状态 WAITING
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "t2");

		t1.start();
		Thread.sleep(100); // 这一步是为了让t1先执行，因为线程的具体执行是操作系统决定的
		t2.start();
	}
}
