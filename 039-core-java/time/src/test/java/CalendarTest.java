import org.junit.Test;

import java.util.Calendar;

/**
 * java.util.Calendar 类中有一些常量很有用
 *
 * @author keqi
 */
public class CalendarTest {

	@Test
	public void test1() {
		Calendar calendar = Calendar.getInstance();

		// 这里只是一个 int 类型的参数，并不是枚举，无法拿到这个字面值
		// 如果要通过反射的方式拿到字面值，那么就没有了存在的意义
		System.out.println(Calendar.YEAR);

	}
}























