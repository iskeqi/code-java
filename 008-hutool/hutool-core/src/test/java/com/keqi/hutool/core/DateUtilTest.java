package com.keqi.hutool.core;

import cn.hutool.core.date.DateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * 测试cn.hutool.core.date.DateUtil类的常用方法
 */
public class DateUtilTest {

	@Test
	public void nowTest() {
		// 当前时间
		Date date = DateUtil.date();
		Assert.assertNotNull(date);
		// 当前时间
		Date date2 = DateUtil.date(Calendar.getInstance());
		Assert.assertNotNull(date2);
		// 当前时间
		Date date3 = DateUtil.date(System.currentTimeMillis());
		Assert.assertNotNull(date3);

		// 当前日期字符串，格式：yyyy-MM-dd HH:mm:ss
		String now = DateUtil.now();
		Assert.assertNotNull(now);
		// 当前日期字符串，格式：yyyy-MM-dd
		String today = DateUtil.today();
		Assert.assertNotNull(today);
	}


}
