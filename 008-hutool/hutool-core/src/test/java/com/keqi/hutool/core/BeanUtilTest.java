package com.keqi.hutool.core;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import org.junit.Test;

import java.util.*;

/**
 * 测试cn.hutool.core.bean.BeanUtil类的相关API
 */
public class BeanUtilTest {

	@Test
	public void copyProperties() {
		User u1 = new User();
		u1.setUsername("username");
		u1.setRoleList(new ArrayList<>());

		for (int i = 0; i < 3; i++) {
			Role role = new Role();
			role.setRoleName("roleName" + i);
			u1.getRoleList().add(role);
		}

		User u2 = new User();

		// 复制Bean对象属性(支持嵌套属性赋值)
		BeanUtil.copyProperties(u1, u2);
		System.out.println(u2);
	}

	@Test
	public void getProperty() {
		Map<String, Object> map = new HashMap<>();
		map.put("username", "keqi");

		List<Role> roles = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Role role = new Role();
			role.setRoleName("roleName" + i);
			List<Premiss> premissList = new ArrayList<>();
			for (int j = 0; j < 4; j++) {
				Premiss p = new Premiss();
				p.setPremissName("premiss" + i + "-" + j);
				premissList.add(p);
				role.setPremissList(premissList);
			}
			roles.add(role);
		}
		map.put("info", roles);

		// 深层次对象的属性获取(无论层次结构有多深，都只需要一行代码，就能够完成)
		String premissName = Convert.convert(String.class,
				BeanUtil.getProperty(map, "info[0].premissList[3].premissName"));
		System.out.println(premissName);
	}

	@Test
	public void test3() {
		RegisterUserParam registerUserParam = new RegisterUserParam();
		registerUserParam.setName("zhagnsna");
		registerUserParam.setAge(19);
		registerUserParam.setScore(123.5);

		// 忽略掉属性为null的字段，这个在调用别人的接口时，非常的有用
		Map<String, Object> stringObjectMap = BeanUtil.
				beanToMap(registerUserParam, false, true);
		System.out.println(stringObjectMap.toString());
	}
}
