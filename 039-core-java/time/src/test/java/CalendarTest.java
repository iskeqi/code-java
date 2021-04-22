import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar 类中有一些常量很有用
 *
 * @author keqi
 */
public class CalendarTest {

	@Test
	public void test1() {
		Calendar calendar = Calendar.getInstance();

		// 获取 Calendar 对象对应的 Date 对象
		Date time = calendar.getTime();

		// 获取 Calendar 对象对应的时间戳
		long timeInMillis = calendar.getTimeInMillis();

		// 这里只是一个 int 类型的参数，并不是枚举，无法拿到这个字面值
		// 如果要通过反射的方式拿到字面值，那么就没有了存在的意义
		// java.util.Calendar 类中有很多代表时间的 int 类型字段，有可能用得上

		System.out.println(Calendar.YEAR);
		System.out.println(Calendar.MONTH);
		System.out.println(Calendar.DATE);

		System.out.println(Calendar.HOUR);
		System.out.println(Calendar.MINUTE);
		System.out.println(Calendar.SECOND);

		System.out.println(Calendar.MILLISECOND);

		// 周一到周日
		System.out.println(Calendar.MONDAY);
		System.out.println(Calendar.TUESDAY);
		System.out.println(Calendar.WEDNESDAY);
		System.out.println(Calendar.THURSDAY);

		// 1月到12月
		System.out.println(Calendar.JANUARY);
		System.out.println(Calendar.FEBRUARY);

		// 对于 Calendar 类，需要了解的也只有这么多了，这几个常量也不建议使用，因为它是从 0 开始的
	}
}























