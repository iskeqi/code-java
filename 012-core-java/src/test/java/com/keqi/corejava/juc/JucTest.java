package com.keqi.corejava.juc;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class JucTest {

	@Test
	public void testAtomicInteger() {
		AtomicInteger count = new AtomicInteger(0);
		// 加1
		int i = count.incrementAndGet();
		System.out.println(i);

		// 减1
		int i1 = count.decrementAndGet();
		System.out.println(i1);
	}

}
