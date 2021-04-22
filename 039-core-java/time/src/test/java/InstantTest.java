import org.junit.Test;

import java.time.Instant;
import java.util.Date;

/**
 * @author keqi
 */
public class InstantTest {

	// java.time.Instant 类表示时刻

	@Test
	public void test1() {
		// 获取表示当前时刻的 Instant 对象
		Instant now = Instant.now();

		Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());

		// Instant 转成 Date 对象
		Date date = new Date(now.toEpochMilli());

		// Date 转成 Instant 对象
		Instant instant1 = Instant.ofEpochMilli(date.getTime());

		// 包含了时区信息的对象内部本质上就是维护了一个 时间戳字段和一个时区字段
		// 没有包含时区信息的对象本质上就只包含了一个代表时间信息的字符串，你并不知道它对应的时间戳是什么，需要根据不同时区来进行解释
	}
}
