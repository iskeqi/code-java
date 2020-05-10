package com.keqi.concurrentjavabasic.communicate.countdownlatch;

public class Main {
	public static void main(String[] args) {
		CoachRacerDemo coachRacerDemo = new CoachRacerDemo();

		Thread thread1 = new Thread(() -> coachRacerDemo.racer());
		Thread thread2 = new Thread(() -> coachRacerDemo.racer());
		Thread thread3 = new Thread(() -> coachRacerDemo.racer());

		Thread thread0 = new Thread(() -> coachRacerDemo.coach());
		thread0.start();
		thread2.start();
		thread1.start();
		thread3.start();

	}
}
