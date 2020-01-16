package com.keqi.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 测试java8时间API的各种例子(下面所有的API其实都不需要掌握了，只要使用hutool类库即可)
 */
public class DateTest {

	/*
	    测试日期格式化时pattern的值不同会有什么影响
	    测试结果是：这里的字母大小是有讲究的，必须固定不变哦。最佳格式：yyyy-MM-dd HH:mm:ss
	 */
	@Test
	public void formatTest() {
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDateTime1 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String localDateTime2 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss"));
		System.out.println(localDateTime1); // 输出结果为：2019-10-07 09:49:27
		System.out.println(localDateTime2); // 输出结果为：2019-49-07 09:49:27 (可见此处格式化错误)

		LocalDate localDate = LocalDate.now();
		String localDate1 = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		// String localDate2 = localDate.format(DateTimeFormatter.ofPattern("yyyy-mm-dd")); // 这行代码直接报错了
		System.out.println(localDate1); // 输出结果为：2019-10-07

		LocalTime localTime = LocalTime.now();
		String localTime1 = localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		// String localTime2 = localTime.format(DateTimeFormatter.ofPattern("HH:MM:ss")); // 这行代码直接报错了
		System.out.println(localTime1); // 输出结果为：09:59:02
	}

	// 获取当前日期
	@Test
	public void getCurrentDate() {
		LocalDate today = LocalDate.now();
		// 可见LocalDate的toString()方法是直接格式化成了yyyy-MM-dd
		System.out.println("Today's Local date : " + today.toString());

		// 这个作为对比
		Date date = new Date();
		System.out.println(date);
	}

	// 获取年、月、日信息
	@Test
	public void getDetailDate() {
		LocalDate today = LocalDate.now();
		// 可见，通过LocalDate类的相关API就能够得到年月日这种数据
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();

		System.out.printf("Year : %d  Month : %d  day : %d t %n", year, month, day);
	}

	//处理特定日期
	@Test
	public void handleSpecilDate() {
		// 通过of()方法直接，指定日期
		LocalDate dateOfBirth = LocalDate.of(2018, 1, 21);
		System.out.println("The specil date is : " + dateOfBirth);
	}

	/*
		java.util.Date 类是一个包含了日期，时间以及时区信息的时间对象，这种方式其实并不好，没有做到关注点分离。
		java8中把日期、时间都分开了，使用不同的对象进行表示。而且他们都不表示时区信息，只有ZonedDateTime包含了时区信息。
		平时，在不需要进行时区的计算时，是完全不需要使用到这个类的，也没有必要考虑任何时区的问题。偶尔使用到这个，可能就是
		把不带时区信息的时间对象转成java.util.Date类的时候，才会用到把。
	*/

	// LocalDate 转 java.util.Date ()
	@Test
	public void localDateToDate() {
		LocalDate localDate = LocalDate.now();
		// 1、获取系统默认时区id(因为java.util.Date是有时区信息的，而java8的时间API除了ZonedDateTime外，都是不带时区信息的)
		ZoneId zoneId = ZoneId.systemDefault(); // toString()结果为："Asia/Shanghai"
		// 2、转成有时区信息的ZonedDateTime对象
		ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
		// 3、先获取当前瞬时时间，然后通过Date类的from(Instant instant)方法转换
		Date from = Date.from(zonedDateTime.toInstant());
		System.out.println(from);
	}

	/*
	    之所以这么麻烦就是因为一个有时区信息，一个没有时区信息。LocalDateTime的转换思路也是一样的，可见ZoneDateTime还是很有用的
	 */

	// java.util.Date 转 LocalDate
	@Test
	public void dateToLocalDate() {
		Date date = new Date();
		// 1、Date对象转成瞬时时间
		Instant instant = date.toInstant();
		// 2、获取本地时区id
		ZoneId zoneId = ZoneId.systemDefault();
		// 3、通过atZone()方法转成带时区信息的ZoneDateTime对象
		ZonedDateTime zonedDateTime = instant.atZone(zoneId);
		// 4、通过toLocalDate()方法转成LocalDate对象
		System.out.println(zonedDateTime.toLocalDate());
	}

	//判断两个日期是否相等
	@Test
	public void compareDate() {
		LocalDate today = LocalDate.now();
		LocalDate date1 = LocalDate.of(2018, 1, 21);
		// LocalDate类重载了equals()方法,直接用就可以
		// 其实它的思路就是计算两个日期距离1970.1.1的时间点的表示时间的数字是否相等
		if (date1.equals(today)) {
			System.out.println("两个日期是相等的");
		} else {
			System.out.println("两个日期是不等的");
		}
	}


	// 格式化日期
	@Test
	public void format () {
		LocalDate today = LocalDate.now();
		// 指定时间格式化成字符串的格式
		String format = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println(format); // 输出结果为：2019-10-06
		// 其实它重写后的toString()方法默认就是输出这种格式
		System.out.println(today.toString()); // 输出结果也是：2019-10-06
	}

	// 解析字符串为日期对象
	@Test
	public void parse () {
		String str = "2019/10/06";
		LocalDate time = LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.println(time); // 输出结果为: 2019-10-06
	}



	// 计算两个日期至今的间隔
	@Test
	public void duration() {
		LocalDateTime time1 = LocalDateTime.of(2019,12,13,12,23,45);
		LocalDateTime time2 = LocalDateTime.of(2020,10,13,23,38,56);

		// 使用Duration类的between()方法来计算两个时间之间的间隔
		// 小的(早)那个时间放在前面，大的(晚)那个时间放在后面，否则计算出来的会是负数
		Duration duration = Duration.between(time1,time2);

		// 间隔天数(未满一天会被忽略)
		System.out.println(duration.toDays());  // 输出结果为：305
		// 间隔小时(未满一小时会被忽略)
		System.out.println(duration.toHours()); // 输出结果为：7331
		// 间隔分钟(未满一分钟会被忽略)
		System.out.println(duration.toMinutes()); // 输出结果为：439875
	}

	// 直接until方法来计算两个日期之间的间隔，使用ChronoUnit类的枚举字段来指定单位
	@Test
	public void until() {
		LocalDateTime time1 = LocalDateTime.of(2019,12,13,12,23,45);
		LocalDateTime time2 = LocalDateTime.of(2020,10,13,23,38,56);
		// 第一个参数比第二个小，返回值为正数，第一个参数比第二个大，返回值为负数。
		System.out.println(time1.until(time2, ChronoUnit.YEARS)); // 输出结果为 0
		System.out.println(time1.until(time2, ChronoUnit.MONTHS)); // 输出结果为 10
		System.out.println(time1.until(time2, ChronoUnit.DAYS)); // 输出结果为 305
		System.out.println(time1.until(time2, ChronoUnit.HOURS)); // 输出结果为 7331
		System.out.println(time1.until(time2, ChronoUnit.MINUTES)); // 输出结果为 439875
		System.out.println(time1.until(time2, ChronoUnit.SECONDS)); // 输出结果为 26392511
	}

	// 通过plus()方法加上指定时间或者minus()方法减去指定时间，得到一个新的时间
	@Test
	public void plus () {
		LocalDate today = LocalDate.now();
		// 第一个参数是个数，第二个参数是时间单位(这里表示在当前时间往后推移两天)
		LocalDate time1 = today.plus(2, ChronoUnit.DAYS);
		LocalDate time2 = today.plus(2, ChronoUnit.WEEKS);
		LocalDate time3 = time2.minus(2, ChronoUnit.WEEKS);
		System.out.println(time1); // 输出结果为：2019-10-08
		System.out.println(time2); // 输出结果为: 2019-10-20
		System.out.println(time3); // 输出结果为: 2019-10-06
	}

	// 通过with()方法配合TemporalAdjusters类感性的调整时间
	@Test
	public void with() {
		LocalDate today = LocalDate.now();
		// 调整到今年的最后一天（如果使用plus()方法就必须要知道具体加多少天，但是这个API就不需要了，可见还是有用的）
		LocalDate time1 = today.with(TemporalAdjusters.lastDayOfYear());
		// 调整到这个月的最后一天
		LocalDate time2 = today.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(time1); // 输出结果为：2019-10-08
		System.out.println(time2); // 输出结果为：2019-10-31
	}

	// 通过isBefore()或者isAfter()方法来判断两个时间的早晚
	@Test
	public void before () {
		LocalDate today = LocalDate.now();
		LocalDate time = LocalDate.of(2018, 1, 29);
		// 使用isBefore()方法时，如果第一个参数小，第二个参数大，则返回值为true
		if (time.isBefore(today)) {
			System.out.println(time + " 早于 " + today);
		} else {
			System.out.println(time + " 晚于 " + today);
		}
	}

	// 把一个时区的时间，转成另一个时区的时间
	@Test
	public void transfer() {
		// 获取一个带有时区信息的系统当前时间
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println(now); // 输出结果为：2019-10-06T16:46:15.295+08:00[Asia/Shanghai]

		// 把本地时区的时间换成指定时区的时间(一个世界时钟程序就这样实现了)
		Instant instant = now.toInstant();
		ZonedDateTime newYorkTime = instant.atZone(ZoneId.of("America/New_York"));
		System.out.println(newYorkTime); // 输出结果为：2019-10-06T04:46:15.295-04:00[America/New_York]
	}

	/**
	 * 计算两个时间的间隔
	 *
	 * @return 返回格式示例："1 天 9 小时 32 分钟" (如果某个单位为零，就会去掉这个单位，比如天为零时，就是 "9 小时 32 分钟" )
	 */
	@Test
	public void calculateDuration() {
		LocalDateTime before = LocalDateTime.now();
		LocalDateTime after = LocalDateTime.of(2021,11,12,12,12,32);
		// 1、计算两个时间相隔多少天
		long days = before.until(after, ChronoUnit.DAYS);

		// 2、除去天数后，计算两个时间相隔多少小时
		LocalDateTime before2 = before.plus(days, ChronoUnit.DAYS);
		long hours = before2.until(after, ChronoUnit.HOURS);

		// 3、除去"小时"候，计算两个时间相隔多少分钟
		LocalDateTime before3 = before2.plus(hours, ChronoUnit.HOURS);
		long minutes = before3.until(after, ChronoUnit.MINUTES);

		// 4、如果某个单位是0的，就直接去掉
		String str1 = days + " 天 ";
		String str2 = hours + " 小时 ";
		String str3 = minutes + " 分钟";
		String result = "";
		result += (days == 0) ? "" : str1;
		result += (hours == 0) ? "" : str2;
		result += (minutes == 0) ? "" : str3;

		System.out.println(result);
	}

	/*
		总结：计算两个时间的间隔或者调整时间的原理其实很简单，就是把人类感性的时间观念，换成理性的简单的数字运算而已。因为，
		计算机中其实就是用一个整数来表示时间的，时间的起始线则是1970年1月1日的零点。比如，比较两个时间的早晚，
		其实就是比较他们对应时间戳的大小而已。这个道理一定要牢牢记住！
	 */
}
