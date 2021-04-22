import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

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

		LocalDateTime of2 = LocalDateTime.of(2021, 4, 21, 22, 22, 22);
		LocalDateTime of3 = LocalDateTime.of(LocalDate.now(), LocalTime.of(20, 21, 21));
		Duration between1 = Duration.between(of2, of3);
		System.out.println(between1.toDays());// 664143
		System.out.println(between1.toHours());//15939440
		System.out.println(of2.until(of3, ChronoUnit.HOURS));//15939440
		System.out.println(of2.until(of3, ChronoUnit.DAYS));//664143

		// 现在需要计算两个 LocalDateTime 之间的间隔是 xx 年 xx 月 xx 日 xx 时 xx 分 xx 秒
		Period between2 = Period.between(of2.toLocalDate(), of3.toLocalDate());
		System.out.println("间隔：" + between2.getYears() + " 年 " + between2.getMonths() + " 月 " +  between2.getDays() + " 日");


	}
}
