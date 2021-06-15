package com.keqi.hutool.core;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
		List<LocalDate> list1 = rangeDay(LocalDate.now().minusDays(7), LocalDate.now().minusDays(1));
		List<LocalDate> list2 = rangeMonth(LocalDate.now(), LocalDate.now().plusDays(765));
		List<LocalDate> list3 = rangeYear(LocalDate.now(), LocalDate.now().plusDays(765));
		
		System.out.println(list1);
	}
	
	public List<LocalDate> rangeDay(LocalDate begin, LocalDate end) {
		List<LocalDate> r = new ArrayList<>();
		while (!begin.isAfter(end)) {
			r.add(begin);
			begin = begin.plus(1, ChronoUnit.DAYS);
		}
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
	
	/**
	 * 获取指定日期之间的列表
	 *
	 * @param begin      开始日期
	 * @param end        结束日期
	 * @param chronoUnit 仅支持 YEARS、MONTHS、DAYS
	 * @return [开始日期, 结束日期]
	 */
	public List<LocalDate> range(LocalDate begin, LocalDate end, ChronoUnit chronoUnit) {
		List<LocalDate> r = new ArrayList<>();
		while (!begin.isAfter(end)) {
			r.add(begin);
			begin = begin.plus(1, chronoUnit);
		}
		return r;
	}
	
	@Test
	public void test3() {
		List<Student> list = new ArrayList<>();
		for (int i = 1; i < 4; i++) {
			Student student = new Student(String.valueOf(i), i, LocalDate.now().minusDays(i));
			list.add(student);
		}
		Map<LocalDate, List<Student>> dateMap = list.stream().collect(Collectors.groupingBy(Student::getBirthday));
		LocalDate begin = LocalDate.now().minusDays(7);
		LocalDate end = LocalDate.now().minusDays(1);
		
		List<Student> students = DateUtilTest.rangeDayFill(begin, end, dateMap, date -> {
			int i = new Random().nextInt(100);
			return new Student(String.valueOf(i), i, date);
		});
		
		System.out.println(students);
	}
	
	public <T> List<T> rangeFill(LocalDate begin, LocalDate end, ChronoUnit chronoUnit, Map<LocalDate, List<T>> timeMap, Function<LocalDate, T> function) {
		List<T> r = new ArrayList<>();
		while (!begin.isAfter(end)) {
			List<T> ts = timeMap.get(begin);
			if (ts != null && ts.size() > 0) {
				r.add(ts.get(0));
			} else {
				r.add(function.apply(begin));
			}
			begin = begin.plus(1, chronoUnit);
		}
		return r;
	}
	
	public <T> List<T> rangeFill(LocalDate begin, LocalDate end, ChronoUnit chronoUnit, long amountToAdd, Map<LocalDate, List<T>> timeMap, Function<LocalDate, T> function) {
		List<T> r = new ArrayList<>();
		while (!begin.isAfter(end)) {
			List<T> ts = timeMap.get(begin);
			if (ts != null && ts.size() > 0) {
				r.add(ts.get(0));
			} else {
				r.add(function.apply(begin));
			}
			begin = begin.plus(amountToAdd, chronoUnit);
		}
		return r;
	}
	
	/**
	 * 将[begin,end]中存在的日期但 dateMap 中不存在的日期进行补全
	 *
	 * @param begin    开始日期
	 * @param end      结束日期
	 * @param dateMap  日期Map
	 * @param function dateList 中存在且dateMap 中不存在时，调用此方法进行对象补全
	 * @param <T>      泛型对象
	 * @return 补全后的对象列表
	 */
	public static <T> List<T> rangeDayFill(LocalDate begin, LocalDate end, Map<LocalDate, List<T>> dateMap, Function<LocalDate, T> function) {
		long until = begin.until(end, ChronoUnit.DAYS) + 1;
		List<T> r = new ArrayList<>((int) until);
		for (int i = 1; i <= until; i++) {
			List<T> ts = dateMap.get(begin);
			if (ts != null && ts.size() > 0) {
				r.add(ts.get(0));
			} else {
				r.add(function.apply(begin));
			}
			begin = begin.plusDays(1);
		}
		return r;
	}
	
	static class Student {
		private String name;
		private Integer age;
		private LocalDate birthday;
		
		public Student() {
		}
		
		public Student(String name, Integer age) {
			this.name = name;
			this.age = age;
		}
		
		public Student(String name, Integer age, LocalDate birthday) {
			this.name = name;
			this.age = age;
			this.birthday = birthday;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public Integer getAge() {
			return age;
		}
		
		public void setAge(Integer age) {
			this.age = age;
		}
		
		public LocalDate getBirthday() {
			return birthday;
		}
		
		public void setBirthday(LocalDate birthday) {
			this.birthday = birthday;
		}
		
		@Override
		public String toString() {
			return "Student{" +
					"name='" + name + '\'' +
					", age=" + age +
					", birthday=" + birthday +
					'}';
		}
	}
}
