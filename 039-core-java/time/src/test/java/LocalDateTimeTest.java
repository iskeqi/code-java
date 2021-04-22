import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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


	}
}
