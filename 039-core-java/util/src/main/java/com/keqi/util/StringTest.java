package com.keqi.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * StringTest
 *
 * @author keqi
 */
public class StringTest {

	public static void main(String[] args) {
		String str = "字符串";
		Charset charset = Charset.defaultCharset();
		byte[] bytes = str.getBytes(charset);

		Charset UTF_8 = StandardCharsets.UTF_8;
		// StandardCharsets 类中提供了几个常用编码的的 Charset 对象，如果没有的话，就使用字符串替代，比如 GBK,GB2312 等
		// sun.nio.cs.ext.ExtendedCharsets 类中指定了很多种编码方式的字符串标准写法，照着这个写就行，不要纠结于大小写以及下划线的问题
		// 这个类是在 charsets.jar 包中

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ceshi");

		System.out.println(stringBuilder.toString());


	}
}
