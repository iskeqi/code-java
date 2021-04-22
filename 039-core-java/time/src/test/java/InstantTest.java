import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author keqi
 */
public class InstantTest {

	@Test
	public void test1() {
		Instant instant = Instant.now();
		System.out.println(instant.toString());

		System.out.println(instant.toEpochMilli());

		Date date = new Date(instant.toEpochMilli());
		System.out.println(date);

		ZoneOffset zoneOffset;
		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println(zoneId.getId());
		Date date1 = new Date(LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
		System.out.println(date1);

		// LocalDate 转换成 Date
		Date date2 = new Date(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
		System.out.println(date2);

		// LocalDateTime 转换成 Date
		System.out.println(new Date(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));

		// LocalDateTime
		ZoneOffset zoneOffset1 = ZoneOffset.ofHours(8);
		System.out.println(zoneOffset1.getId());

		// 今年的第 112 天
		System.out.println(LocalDate.now().getDayOfYear());

		// 这周的第 4 天
		System.out.println(LocalDate.now().getDayOfWeek().getValue());

		// 这月的第 22 天
		System.out.println(LocalDate.now().getDayOfMonth());
	}
}
