package com.keqi.springbootdesignpattern.pattern.behavior.observer;

/**
 * 观察者模式
 */
public class ObserverPatternDemo {

	/*
		设计模式的核心在于思想，而不是具体的代码实现

		观察者模式的核心在于被观察者持有了观察者的引用，然后再发生了指定事件后，主动的去通知观察者

		至于用何种方式让被观察者持有观察者的引用，这是无足轻重的事情，可以根据具体情况看着来

		换句话来说，其实天天都在用观察者模式，controller调用service，service就去调用mapper
		这就是发生了某件事情，然后触发了一系列的联动操作啊


	 */


	public static void main(String[] args) {
		Subject subject = new Subject();

		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("Second state change: 10");
		subject.setState(10);
	}
}
