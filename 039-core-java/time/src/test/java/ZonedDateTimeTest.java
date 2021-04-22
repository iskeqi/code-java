import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author keqi
 */
public class ZonedDateTimeTest {

	@Test
	public void test1() {
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println(now);

		System.out.println(now.toLocalDateTime());

		System.out.println(now.toInstant());
	}
}
