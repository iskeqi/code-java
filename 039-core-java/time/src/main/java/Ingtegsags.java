/**
 * @author keqi
 */
public interface Ingtegsags {

	// 即便实现了这个接口的类没有实现此方法，仍然会继承此方法
	default void test1() {}

	// 只有通过接口才能访问此方法，其它方式都是不允许的
	static void test2() {
		System.out.println("test2");
	}

	// 实现了此接口的方法，必须实现此接口
	void test3();
}
