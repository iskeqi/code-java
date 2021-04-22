import org.junit.Test;

import java.time.ZoneId;
import java.util.Set;

/**
 * @author keqi
 */
public class ZoneIdTest {

	@Test
	public void test1() {
		Set<String> sets = ZoneId.getAvailableZoneIds();
		System.out.println(sets.size());

		// ZoneId 这个类内部维护了 601 个地区的时区信息

		// 获取系统中默认的时区
		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println(zoneId);

		ZoneId of = ZoneId.of("Asia/Shanghai");
		System.out.println(of);
	}
}
