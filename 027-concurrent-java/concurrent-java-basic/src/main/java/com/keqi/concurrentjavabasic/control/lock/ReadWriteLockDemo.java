package com.keqi.concurrentjavabasic.control.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

	private Map<String, String> map = new HashMap<>();

	// 读写锁对象
	private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

	// 通过读写锁对象得到读锁
	private ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
	// 通过读写锁对象得到写锁
	private ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

	public String get(String key) {
		readLock.lock(); // 读操作加锁
		try {
			System.out.println(Thread.currentThread().getName() + "读操作已加锁，开始读操作...");
			Thread.sleep(3000);
			return this.map.get(key);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
			System.out.println(Thread.currentThread().getName() + "读操作已解锁");
		}
		return null;
	}

	public void put(String key, String value) {
		writeLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "写操作已加锁，开始写操作");
			Thread.sleep(3000);
			map.put(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			writeLock.unlock();
			System.out.println(Thread.currentThread().getName() + "写操作已解锁");
		}
	}

	public static void main(String[] args) {
		// 可见如果都是读的话，即便加锁了，也当做不存在，如果有读有写，那么就会互斥的哦

		// 这不就是相当于自己编写了一个线程安全的HashMap吗？哈哈哈
		// 以你现在掌握的知识，都可以去了解一下线程安全的集合都是怎么实现的了哦

		// synchronized 适合小段代码
		// Lock 适合大段代码


		ReadWriteLockDemo writeLockDemo = new ReadWriteLockDemo();
		writeLockDemo.put("key1", "key2");
		Thread thread1 = new Thread(() -> System.out.println(writeLockDemo.get("key1")));
		Thread thread2 = new Thread(() -> System.out.println(writeLockDemo.get("key1")));
		Thread thread3 = new Thread(() -> System.out.println(writeLockDemo.get("key1")));

		thread1.start();
		thread2.start();
		thread3.start();
	}

}
