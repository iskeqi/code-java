import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DurationTest {

	@Test
	public void test1() {
		LocalTime of = LocalTime.of(12, 12, 12);
		LocalTime of1 = LocalTime.of(22, 22, 22);


		// Duration 类能够表示两个时间段之间间隔的 天、时、分、毫秒
		Duration between = Duration.between(of, of1);

		System.out.println(between.toDays()); // 0
		System.out.println(between.toHours()); // 10
		System.out.println(between.toMinutes()); // 610
		System.out.println(between.toMillis()); //36610000
		System.out.println(of.until(of1, ChronoUnit.MINUTES));// 610

		// 对于 Duration 中的 toXXX() 方法的作用和 until() 方法的作用是相同的
		// 表示两个时间之间的间隔是 xxx 单位

		LocalDateTime of2 = LocalDateTime.of(2020, 10, 22, 22, 22, 22);
		LocalDateTime of3 = LocalDateTime.of(2021, 4, 21, 22, 20, 21);
		Duration between1 = Duration.between(of2, of3);
		System.out.println(between1.toDays());// 664143
		System.out.println(between1.toHours());//15939440
		System.out.println(of2.until(of3, ChronoUnit.HOURS));//15939440
		System.out.println(of2.until(of3, ChronoUnit.DAYS));//664143

		// 现在需要计算两个 LocalDateTime 之间的间隔是 xx 年 xx 月 xx 日 xx 时 xx 分 xx 秒


		System.out.println(of2.until(of3, ChronoUnit.YEARS)); // 0
		System.out.println(of2.until(of3, ChronoUnit.MONTHS)); //
		System.out.println(of2.until(of3, ChronoUnit.DAYS));
		System.out.println(of2.until(of3, ChronoUnit.HOURS));
		System.out.println(of2.until(of3, ChronoUnit.MINUTES));
		System.out.println(of2.until(of3, ChronoUnit.SECONDS));
	}


	@Test
	public void cal() {
		// 计算 xx 年 xx 月 xx 日 xx 时 xx 分 xx 秒
		LocalDateTime time1 = LocalDateTime.of(2021, 4, 21, 22, 20, 21);
		LocalDateTime time2 = LocalDateTime.of(2020, 10, 22, 22, 22, 22);


		int year = time1.getYear();
		int month = time1.getMonthValue();
		int day = time1.getDayOfMonth();
		int hours = time1.getHour();
		int minute = time1.getMinute();
		int second = time1.getSecond();

		int i = second - time2.getSecond();
		if (i < 0 ) {
			System.out.println(i + 60);
			minute = minute - 1;
		} else {
			System.out.println(i);
		}

		int i2 = minute - time2.getMinute();
		if (i2 < 0 ) {
			System.out.println(i2 + 60);
			hours = hours - 1;
		} else {
			System.out.println(i2);
		}

		int i3 = hours - time2.getHour();
		if (i3 < 0 ) {
			System.out.println(i3 + 24);
			day = day - 1;
		} else {
			System.out.println(i3);
		}

		int i4 = day - time2.getDayOfMonth();
		if (i < 0 ) {
			LocalDate with = LocalDate.of(time1.getYear(), time1.getMonthValue(), 1).with(TemporalAdjusters.lastDayOfMonth());
			int dayOfMonth = with.getDayOfMonth();
			System.out.println(i4 + dayOfMonth);
			month = month - 1;
		} else {
			System.out.println(i4);
		}

		int i5 = month - time2.getMonthValue();
		if (i < 0 ) {
			System.out.println(i5 + 12);
			year = year - 1;
		} else {
			System.out.println(i5);
		}

		int i6 = year - time2.getYear();
		System.out.println(i6);
	}

}
