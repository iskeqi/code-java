package com.keqi.hutool.core;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.CharUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试cn.hutool.core.collection.CollectionUtil的使用
 */
public class CollectionUtilTest {

	@Test
	public void LocalDateTimeToDate() {
		List<Long> idList = new ArrayList<>();
		for (long i  = 0; i < 10; i++) {
			idList.add(i);
		}

		// String 类是实现了CharSequence接口的
		// 利用CharUtil类的常量来避免自己写单个字符，如果没有还可以利用ASCII编码来进行转换
		String join = CollectionUtil.join(idList, String.valueOf(CharUtil.COMMA));
		System.out.println(join);
	}
}
