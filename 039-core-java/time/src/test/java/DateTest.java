import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateTest
 *
 * @author keqi
 */
public class DateTest {

	@Test
	public void test1() throws ParseException {
		// 创建代表当前时间的 Date 对象
		Date date = new Date();
		System.out.println(date.getTime());

		// 使用 SimpleDateFormat 对象进行 Date 类的格式化和解析
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));

		Date date1 = sdf.parse("2021-04-22 15:52:57");
		System.out.println(date1);

		// 以当前时区代表的时间戳创建 Date 对象
		Date date2 = new Date(System.currentTimeMillis());
		System.out.println(date2);

		// 以上就是 java.util.Date 类需要掌握的全部知识点，其它知识点都已经过时了，无需掌握
	}
}
