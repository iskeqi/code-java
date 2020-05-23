package com.keqi.hutool.core;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.XmlUtil;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XmlUtilTest {

	@Test
	public void test1 () {
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("username", "keqi");
		userMap.put("age", 23);

		XmlUtil.writeObjectAsXml(new File("userMap.xml"), userMap);

		// 这好像不是我要的方法呀
		Map<String, Object> o = (Map) XmlUtil.readObjectFromXml(new File("userMap.xml"));
		System.out.println(o instanceof Map);
		System.out.println(MapUtil.getInt(o, "age"));
	}
}
