import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Month;

/**
 * JDK 内部存在很多时间枚举类，完全可以复用他的，而没有必要去自定义枚举类，想想也知道，这么通用的需求，肯定会有存在的
 * @author keqi
 */
public class TimeEnumTest {


	@Test
	public void test1() {
		for (Month value : Month.values()) {
			System.out.println(value.name() + "  " + value.getValue()) ;
		}
		System.out.println("========================================");
		for (DayOfWeek value : DayOfWeek.values()) {
			System.out.println(value.name() + "  " + value.getValue()) ;
		}

	}


















}
