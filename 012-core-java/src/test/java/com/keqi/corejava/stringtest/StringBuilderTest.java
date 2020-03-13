package com.keqi.corejava.stringtest;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class StringBuilderTest {

	@Test
	public void testAtomicInteger() {
		StringBuilder stringBuilder = new StringBuilder();
		String s = stringBuilder.toString();
		System.out.println(s);
		System.out.println("".equals(s));
		System.out.println(s.length());
	}
}
