package set;

import java.util.HashSet;

/**
 * @author keqi
 */
public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet();
		// 输出为 true
		System.out.println(hashSet.add("a"));
		// 输出为 false
		System.out.println(hashSet.add("a"));

		// HashSet 本质上就是一个 HashMap，只不过可以不用写 value ，value 默认就是 PRESENT ，一个普通object对象
	}
}
