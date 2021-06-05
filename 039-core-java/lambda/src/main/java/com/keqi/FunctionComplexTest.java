package com.keqi;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author keqi
 */
public class FunctionComplexTest {
	
	/*
		lambda 表达式不仅可以作为方法参数进行传递，也可以作为方法返回值进行返回
		实际上就是传递了一个对象作为参数，返回了一个对象作为返回值
		
		但是直观上的体现是传递的代码，代码是参数、代码是返回值
	 */
	
	public static void main(String[] args) {
		FunctionComplexTest functionComplexTest = new FunctionComplexTest();
		functionComplexTest.test1();
	}
	
	public void test1() {
		Integer[] arr = new Integer[]{3,4,2,1,5,6};
		// 匿名内部类的编写方式
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		System.out.println(Arrays.toString(arr));
	}
	
	public void test2() {
		Integer[] arr = new Integer[]{3,4,2,1,5,6};
		// lambda 表达式的编写方式
		Arrays.sort(arr, (o1, o2) -> o1.compareTo(o2));
		
		System.out.println(Arrays.toString(arr));
	}
	
	public void test3() {
		Integer[] arr = new Integer[]{3,4,2,1,5,6};
		// 方法引用的编写方式 表达式的编写方式
		Arrays.sort(arr, Integer::compareTo);
		
		System.out.println(Arrays.toString(arr));
	}
	
	
}
