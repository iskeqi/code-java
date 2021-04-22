import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest {

	@Test
	public void test1() {
		// Period 表示日期之间的差，用年月日表示(仅支持这三种单位，其他也不支持，否则会抛异常)，不能用于时间
		LocalDate of1 = LocalDate.of(2020, 1, 1);
		LocalDate of2 = LocalDate.of(1000, 1, 1);

		Period between1 = Period.between(of1, of2);
		System.out.println(between1.getYears()); // -1020
		System.out.println(between1.getMonths());// 0  这个结果与直观的表示不同
		System.out.println(between1.getDays());// 0
		System.out.println(between1.get(ChronoUnit.DAYS)); // 0

		System.out.println(of1.until(of2, ChronoUnit.DAYS));// 输出的是 -372547

		// Period 类表示两个 LocalDate 之间的日期间隔，描述间隔的方式是：xx 年 xx 月 xx 日
		// until 方法中则是通过枚举类 ChronoUnit 指定一个单位，描述间隔的方式是 xxx 单位
		// 所以，这两个方法并不是多余的，而是互相补充的关系


	}
}

