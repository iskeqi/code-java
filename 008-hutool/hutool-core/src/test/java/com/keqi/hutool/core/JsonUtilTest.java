package com.keqi.hutool.core;

import cn.hutool.json.JSONUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 */
public class JsonUtilTest {

	Map<String, Object> obj = null;

	@Before
	public void init() {
		 obj = new HashMap<>();
		 obj.put("username","keqi");
		 obj.put("password","123456");
	}


	@Test
	public void test() {
		// 测试对象转json字符串
		System.out.println(JSONUtil.toJsonStr(obj));
	}

	@Test
	public void testNull() {
		// 测试对象转json字符串时,null值会不会被输出
		// 答案是会的，这非常的好
		obj.put("girl", null);
		System.out.println(JSONUtil.toJsonStr(obj));
	}

}
