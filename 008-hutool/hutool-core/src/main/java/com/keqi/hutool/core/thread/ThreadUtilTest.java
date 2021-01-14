package com.keqi.hutool.core.thread;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;

/**
 * 测试 cn.hutool.core.thread.ThreadUtil 相关 API 使用
 */
public class ThreadUtilTest {

	public static void main(String[] args) {
		System.out.println(generateProcessingTimeLimit(0, 0));
	}

	private static String generateProcessingTimeLimit(Integer hour, Integer minute) {
		if (hour == null || minute == null) {
			return "";
		}


		BigDecimal div = NumberUtil.div(String.valueOf(minute), String.valueOf(60), 2);
		BigDecimal sum = NumberUtil.add(div, new BigDecimal(hour));
		return sum.toString() + "h";
	}
}
