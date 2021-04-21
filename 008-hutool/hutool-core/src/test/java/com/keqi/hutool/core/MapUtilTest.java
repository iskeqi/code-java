package com.keqi.hutool.core;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.NumberUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapUtilTest {

	Map<String, Object> objMap = null;

	@Before
	public void init() {
		objMap = new HashMap<>();
		objMap.put("username","keqi");
		objMap.put("password","123456");
		objMap.put("password2","12G3456");
		objMap.put("password4","");
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

		// 如果从Map中获取的key对应的值是一个""
		String password4 = MapUtil.getStr(objMap, "password4");
		// 在做类型转换时，把它转成Long类型，那么返回值肯定是null
		Long aLong4 = Convert.toLong(password4);

		// 总结：cn.hutool.core.convert.Convert 类在无法转换时，并不会抛出异常，而是返回一个null

		System.out.println("-");
	}

	@Test
	public void testMap() {
		Map<String, Object> param = new HashMap<>();
		param.put("name", "name");
		param.remove("name");
		System.out.println(param == null);
		System.out.println(param.size());

		double a = 100;
		double b = 100;
		System.out.println(NumberUtil.sub(1, NumberUtil.div(a, b)));

		System.out.println(NumberUtil.div(1, 1));

		System.out.println(calculatePercentage(1,0));
	}

	private double calculatePercentage(double a, double b) {
		if (Objects.equals(a, b)) {
			return 0;
		} else if (Objects.equals(a, 0D)) {
			return 1;
		} else if (Objects.equals(b, 0D)) {
			return -1;
		}
		else {
			return NumberUtil.div(NumberUtil.sub(b, a), a);
		}
	}
}
