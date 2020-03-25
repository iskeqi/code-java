package com.keqi.hutool.core;

import cn.hutool.core.lang.Validator;
import org.junit.Test;

/**
 * Validator 类使用
 */
public class ValidatorTest {

	@Test
	public void DateToLocalDateTime() {
		// 几个常见的验证规则，Validator类提供了内置的
		System.out.println(Validator.isEmail("eq41"));

		// 校验是否满足正则表达式
		// Validator.isMactchRegex();

		// 验证字符串是否是标准的年月日时分秒的格式（Validator类并未直接提供这种方法）
		// 只能自己的项目中利用 SimpleDateFormat 的 parse() 方法来检测是否能够正确解析为Date类型
		// 来判断是否满足标准的日期格式字符串，在自己项目中封装一个公共工具类即可（不知道怎么分类的就
		// 放在这个工具类里面）
	}
}
