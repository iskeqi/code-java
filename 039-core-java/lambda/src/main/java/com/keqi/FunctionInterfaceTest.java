package com.keqi;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author keqi
 */
public class FunctionInterfaceTest {

	public static void main(String[] args) {
		// 这些函数式接口广泛的应用在 stream api 操作中，如果自己需要的话，也可以用在自己日常编程中
		Predicate<String> predicate;
		Function<String, Class<?>> function;
		Consumer<String> consumer;
	}

}
