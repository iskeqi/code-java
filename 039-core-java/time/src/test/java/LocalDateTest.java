import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author keqi
 */
public class LocalDateTest {

	@Test
	public void test1() {
		LocalDate now = LocalDate.now();
		System.out.println(now);

		ZonedDateTime zonedDateTime = now.atStartOfDay(ZoneId.systemDefault());
		System.out.println(zonedDateTime);

		Date date = new Date(zonedDateTime.toInstant().toEpochMilli());
		System.out.println(date);

		// LocalDate -> Date
		// 其实只需要一行代码
		Date d = new Date(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());

		// Date -> 转成 LocalDate
		// 同样只需要一行代码
		LocalDate localDate = ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault()).toLocalDate();


		// 不同时区间的时间转换，其实也很简单啦，嘿嘿
		ZonedDateTime now1 = ZonedDateTime.now();
		Instant instant = now1.toInstant();

		ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(instant, ZoneId.of("Australia/Darwin"));
		System.out.println(zonedDateTime1);
	}
}
