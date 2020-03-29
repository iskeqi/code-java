package com.keqi.concurrentjavabasic.priority;

public class priorityDemo {

	public static void main(String[] args) {
		Thread a = new Thread();
		System.out.println("线程默认优先级：" + a.getPriority());

		Thread b = new Thread();
		b.setPriority(10);
		System.out.println("线程优先级：" + b.getPriority());
	}
}
