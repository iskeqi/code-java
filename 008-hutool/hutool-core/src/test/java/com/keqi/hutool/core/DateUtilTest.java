package com.keqi.hutool.core;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试cn.hutool.core.date.DateUtil类的常用方法
 */
public class DateUtilTest {
	
	@Test
	public void LocalDateTimeToDate() {
		// LocalDateTime -> Date
		LocalDateTime now = LocalDateTime.now();
		Date date = DateUtil.date(now).toJdkDate();
	}
	
	@Test
	public void LocalDateToDate() {
		// LocalDate -> Date
		LocalDate now = LocalDate.now();
		Date date = DateUtil.date(now).toJdkDate();
	}
	
	@Test
	public void DateToLocalDateTime() {
		// Date -> LocalDateTime
		Date date = new Date();
		LocalDateTime localDateTime = DateUtil.toLocalDateTime(date);
	}
	
	@Test
	public void DateToLocalDate() {
		// Date -> LocalDate
		Date date = new Date();
		LocalDateTime localDateTime = DateUtil.toLocalDateTime(date);
		LocalDate localDate = localDateTime.toLocalDate();
	}

	/*
		总结：平时项目中直接使用java8的API就行了，但是遇到复杂的时间操作的时候，还是需要用DateUtil工具类，
		这个DateUtil类是完全兼容java8新的API的哦

		LocalDate/LocalDateTime类都有一个共同的接口TemporalAccessor，所有java8时间API转date类，直接使用
		DateUtil类的public static DateTime date(TemporalAccessor temporalAccessor)方法即可
	 */
	
	@Test
	public void rangeToList() {
		Date startDate = DateUtil.parseDate("2019-12-08");
		Date endDate = DateUtil.parseDate("2020-01-12");
		// 直接返回的是一个[2019-12-08,2020-01-12]之间的List对象，这就是之前一直都需要用到的方法呀
		List<DateTime> dateTimes = DateUtil.rangeToList(startDate, endDate, DateField.DAY_OF_MONTH);
		dateTimes.forEach(System.out::println);
	}
	
	/**
	 * 验证日期字符串格式
	 */
	@Test
	public void check() {
		String str1 = "2019-12-12";
		String str2 = "201-12-212";
		DateTime dateTime = DateUtil.parseDate(str1);
		DateTime dateTime1 = DateUtil.parseDate(str2);
		
		// 输出：2019-12-12 00:00:00
		System.out.println(dateTime);
		
		// 输出：0202-06-30 00:00:00
		System.out.println(dateTime1);
		// 即便不符合日期格式，也不会报错。
	}
	
	@Test
	public void test1() {
		List<DateTime> list1 = DateUtil.rangeToList(DateUtil.date(LocalDate.now().minusDays(6)),
				DateUtil.date(LocalDate.now()), DateField.DAY_OF_YEAR);
		List<DateTime> list2 = DateUtil.rangeToList(DateUtil.date(LocalDate.now().minusMonths(6)),
				DateUtil.date(LocalDate.now()), DateField.MONTH);
		List<DateTime> list3 = DateUtil.rangeToList(DateUtil.date(LocalDate.now().minusYears(6)),
				DateUtil.date(LocalDate.now()), DateField.YEAR);
		
		System.out.println("ss");
	}
	
	@Test
	public void test2() {
		List<LocalDate> list1 = rangeDay(LocalDate.now(), LocalDate.now().plusDays(765));
		List<LocalDate> list2 = rangeMonth(LocalDate.now(), LocalDate.now().plusDays(765));
		List<LocalDate> list3 = rangeYear(LocalDate.now(), LocalDate.now().plusDays(765));
		
		System.out.println(list1);
	}
	
	public List<LocalDate> rangeDay(LocalDate begin, LocalDate end) {
		List<LocalDate> r = new ArrayList<>();
		do {
			r.add(begin);
			begin = begin.plus(1, ChronoUnit.DAYS);
		} while (!begin.isAfter(end));
		return r;
	}
	
	public List<LocalDate> rangeMonth(LocalDate begin, LocalDate end) {
		List<LocalDate> r = new ArrayList<>();
		do {
			r.add(begin);
			begin = begin.plus(1, ChronoUnit.MONTHS);
		} while (!begin.isAfter(end));
		return r;
	}
	
	public List<LocalDate> rangeYear(LocalDate begin, LocalDate end) {
		List<LocalDate> r = new ArrayList<>();
		do {
			r.add(begin);
			begin = begin.plus(1, ChronoUnit.YEARS);
		} while (!begin.isAfter(end));
		return r;
	}
}
