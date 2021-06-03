import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author keqi
 */
public class LocalDateTimeTest {

	@Test
	public void test1() {
		LocalDateTime now = LocalDateTime.now();

		System.out.println(now);

		ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
		System.out.println(zonedDateTime);

		LocalDateTime of = LocalDateTime.of(2020, 1, 1, 1,1,1);
		
		System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59, 59)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}
}
