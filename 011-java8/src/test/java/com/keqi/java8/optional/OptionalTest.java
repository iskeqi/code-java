package com.keqi.java8.optional;

import org.junit.Test;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

public class OptionalTest {

	@Test
	public void test1 () {
		Optional<Object> empty = Optional.empty();
		if (!empty.isPresent()) {
			System.out.println("Optional类中的属性value没有值");
		} else {
			System.out.println("Optional类中的属性value没有值");
		}
	}

	@Test
	public void test2() {
		String url = "jdbc:mysql://localhost:3306/test";
		Optional<String> opt = Optional.of(url);
		String s = opt.get();
		System.out.println("封装在Optional类中的字符串对象为："  + s);
	}

	@Test
	public void test3() {
		Boy tom = getBoy();
		Optional<Boy> opt1 = Optional.ofNullable(tom);
		Boy boy = opt1.orElse(new Boy("keqi",null));

		Girl girlFriend = boy.getGirlFriend();
		Optional<Girl> opt2 = Optional.ofNullable(girlFriend);
		Girl grace = opt2.orElse(new Girl("grace"));

		String nickName = grace.getNickName();
		System.out.println("the name of girlFriend is : " + nickName);
	}

	/*
		使用 if (obj == null) 的方式来避免空指针，这种方式很常规，但是冗长又很low
	 */
	public static String test4() {
		Boy boy = getBoy();
		Girl girlFriend = null;
		if (boy != null) {
			girlFriend = boy.getGirlFriend();
		}
		String nickName = null;
		if (girlFriend != null) {
			nickName = girlFriend.getNickName();

		}
		return nickName;
	}

	/*
		使用java.util.Optional类把目标对象进行包装，可以有效的避免空指针判断
	 */
	public static String test5() {
		// 如果getBoy()方法返回值为null，就new一个没有任何属性值的对象出来，避免空指针异常
		Optional<Boy> opt1 = Optional.ofNullable(getBoy());
		Boy boy = opt1.orElse(new Boy());

		// 如果getGirlFriend()方法返回值为null，就new一个没有任何属性的对象出来，避免空指针异常
		Optional<Girl> opt2 = Optional.ofNullable(boy.getGirlFriend());
		Girl girl = opt2.orElse(new Girl());
		return girl.getNickName();
	}

	/*
	    不进行任何空指针判断的情况下，代码可以写成这样子。非常简洁，但是很可能会报空指针异常
	 */
	public static String test6() {
		// boy 可能为 null
		Boy boy = getBoy();
		// 即便boy不是null,但是gitlFirend还是可能为null的
		Girl girlFriend = boy.getGirlFriend();
		return girlFriend.getNickName();
	}

	private static Boy getBoy() {
		return null;
	}

	@Test
	public void test13() throws Throwable {
		String id = this.t1().orElseThrow((Supplier<Throwable>) () -> new RuntimeException("非法id"));
		System.out.println(id);
	}

	// Optional 类的真正作用是，显示的告知调用者，这个返回值有可能是为 null 的
	private Optional<String> t1() {
		Random random = new Random();
		int i = random.nextInt(10);
		return i % 2 == 0 ? Optional.empty() : Optional.of("optional");
	}

}
