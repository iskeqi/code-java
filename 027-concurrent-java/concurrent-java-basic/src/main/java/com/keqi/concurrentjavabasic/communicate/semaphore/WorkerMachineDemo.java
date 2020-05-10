package com.keqi.concurrentjavabasic.communicate.semaphore;

import java.util.concurrent.Semaphore;

public class WorkerMachineDemo {

	public static void main(String[] args) {
		int workers = 8; // 代表工人数
		Semaphore semaphore = new Semaphore(3); // 代表机器数
		for (int i =0; i< workers; i++) {
			Thread thread = new Thread(new Work(workers, semaphore));
			thread.start();
		}
	}
}
