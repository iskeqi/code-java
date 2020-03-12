package com.keqi.hutool.core;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapUtilTest {

	Map<String, Object> objMap = null;

	@Before
	public void init() {
		objMap = new HashMap<>();
		objMap.put("username","keqi");
		objMap.put("password","123456");
		objMap.put("password2","12G3456");
	}


	@Test
	public void test() {
		String username = MapUtil.getStr(objMap, "username");

		String password = MapUtil.getStr(objMap, "password");
		Long aLong = Convert.toLong(password);

		String password2 = MapUtil.getStr(objMap, "password2");
		// Convert类中的转换方法，如果无法正确转换，并不会抛出异常，而是返回一个 null 值
		Long aLong2 = Convert.toLong(password2);

		// 如果是从Map中获取一个并不存在的值，那么肯定是null了
		String password3 = MapUtil.getStr(objMap, "password3");
		// 一个null值，去转换，返回也会是一个null
		Long aLong3 = Convert.toLong(password3);

		System.out.println("-");
	}
}
