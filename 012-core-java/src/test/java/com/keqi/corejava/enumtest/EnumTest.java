package com.keqi.corejava.enumtest;

import org.junit.Test;

public class EnumTest {

	@Test
	public void test() {
		java.lang.Enum obj;
		System.out.println(DataSourceTypeEnum.MASTER);
	}

	@Test
	public void testEnumEquals() {
		// 这样比较肯定是不等的，一个是枚举对象一个知识字符串
		System.out.println(SampleTypeEnum.ALL.equals("ALL")); // 输出为false

		// 如果枚举是没有值的呢？
		System.out.println(DataSourceTypeEnum.MASTER.equals("MASTER")); // 输出仍然为false
	}

	@Test
	public void testEnumName() {
		String ALL = "ALL";

		// 枚举类是重写了toString() 方法的
		System.out.println(SampleTypeEnum.ALL.toString());
		// 通过枚举类的name()方法，也是可以直接获取到对象的名字的那个字符串的哦
		System.out.println(SampleTypeEnum.ALL.name());

		System.out.println(SampleTypeEnum.ALL.name().equals(ALL)); // 输出为true

		System.out.println(SampleTypeEnum.ALL.toString().equals(ALL)); // 输出为true
	}

	@Test
	public void testUserTypeEnum() {
		String userType = "SUPER_ADMIN";
		// 这样做的确挺好的，确实是毫无问题了
		if (userType.equals(UserTypeEnum.SUPER_ADMIN.name())) {
			System.out.println(UserTypeEnum.SUPER_ADMIN.getMsg());
		}
	}

	@Test
	public void testEnumDictName() {
		// 如果从数据库中查询出出来的数据直接封装成了一个枚举对象，那么如何从一个枚举对象换成VO中的字符串呢？
		UserTypeEnum userType = UserTypeEnum.TENANT_ADMIN;
		// 干脆继承一个统一的接口，然后每个枚举类中的这个字段名字统一叫做valueName，然后通过接口中的方法统一获取这个值
		// 那么用起来就非常的方便咯，为啥之前都不知道用这种方式呢？单独抽离出来一个VO，在VO进行转换的时候，这样搞就行了
		String userTypeName = userType.getMsg();
		System.out.println(userTypeName);
	}

	@Test
	public void testEnumClass() {
		String userType = "SUPER_ADMIN";
		// Enum类的静态方法valueOf()还是很有用的哦，可以通过name直接得到对应的对象，这不就是你之前一直想要找到的方法么
		// 这就是现成的啊。

		// 使用场景：前端传递给你一个字符串，你想要把它变成自己之前已经写好的枚举类对象，直接用这个方法就行
		UserTypeEnum userTypeEnum = Enum.valueOf(UserTypeEnum.class, userType);
		System.out.println(userTypeEnum); // 输出为
	}

	@Test
	public void testValues() {
		// 每一个枚举类中都有的values()方法，还是很有用的哦，用起来也非常的方便呀
		UserTypeEnum[] values = UserTypeEnum.values();
		for (UserTypeEnum value : values) {
			System.out.println(value.name() + "->" + value.getMsg());
		}
	}

}
