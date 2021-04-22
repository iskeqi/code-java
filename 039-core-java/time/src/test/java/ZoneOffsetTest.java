import org.junit.Test;

import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @author keqi
 */
public class ZoneOffsetTest {

	@Test
	public void test1() {
		// ZoneOffSet 类是 抽象类 ZoneId 的子类，可以通过指定加减小时的方式去找到对应的时区对象

		ZoneId zoneId = ZoneOffset.systemDefault();

		System.out.println(ZoneOffset.ofHours(8).getId());

		System.out.println(ZoneOffset.of("+08:00").getId());

		System.out.println(ZoneOffset.ofHours(-10).getId());

		System.out.println(((ZoneId) ZoneOffset.ofHours(10)).getId());

		ZoneId zoneId1 = ZoneId.ofOffset("GMT", ZoneOffset.ofHours(-10));
		System.out.println(zoneId1);
	}
}
