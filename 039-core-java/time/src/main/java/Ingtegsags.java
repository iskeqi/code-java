/**
 * @author keqi
 */
public interface Ingtegsags {

	default void test1() {}

	static void test2() {
		System.out.println("test2");
	}

	void test3();
}
