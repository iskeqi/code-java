package com.keqi.concurrentjavabasic.control.threadlocal;

public class ThreadLocalDemo {

	// 创建银行对象：钱、存款、取款
	static class Bank {
		private ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

		public Integer get() {
			return threadLocal.get();
		}

		public void set(Integer money) {
			threadLocal.set(threadLocal.get() + money);
		}

	}

	// 创建一个转账对象：从银行中取钱，转账，保存到账户
	static class Transfer implements Runnable {

		private Bank bank;

		public Transfer(Bank bank) {
			this.bank = bank;
		}

		@Override
		public void run() {
			for (int i =0 ; i< 10; i++){
				bank.set(10);
				System.out.println(Thread.currentThread().getName() +"账户余额：" + bank.get());
			}
		}
	}


	// 在 main 方法中使用两个对象模拟转账
	public static void main(String[] args) {
		Bank bank = new Bank();
		Transfer transfer = new Transfer(bank);
		Thread thread1 = new Thread(transfer, "线程1");
		Thread thread2 = new Thread(transfer, "线程2");
		thread1.start();
		thread2.start();
	}
}
