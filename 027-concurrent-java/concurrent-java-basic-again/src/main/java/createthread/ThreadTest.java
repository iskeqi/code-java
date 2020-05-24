package createthread;

public class ThreadTest {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		t1.start();
	}

	/**
	 * 通过继承 Thread 类的方式创建线程（必须要单独编写一个类，无法使用匿名内部类/lambda的写法）
	 */
	static class Thread1 extends Thread {
		@Override
		public void run() {
			System.out.println("线程名称：" + this.getName());
			System.out.println("线程名称：" + Thread.currentThread().getName());
		}
	}
}
