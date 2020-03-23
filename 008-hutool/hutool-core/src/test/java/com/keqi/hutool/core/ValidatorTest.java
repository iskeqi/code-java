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
	}
}
