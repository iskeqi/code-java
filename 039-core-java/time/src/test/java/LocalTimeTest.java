import org.junit.Test;

import java.time.LocalTime;

/**
 * @author keqi
 */
public class LocalTimeTest {

	@Test
	public void test1() {
		LocalTime now = LocalTime.now();

		System.out.println(now);
	}
}
