package map;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMapTest
 *
 * @author keqi
 */
public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("name", "keqi");
		map.put("age", "24");

		// 遍历Map的几种方式

		// 获取到所有的 key ，再根据 key 去找到 value（效率太低，不推荐）
		Set<String> strings = map.keySet();

		// 直接获取到所有的 Map.Entry<String, String> 对象（推荐用法，挺好）
		Set<Map.Entry<String, String>> entries = map.entrySet();

		// 获取到所有值，不是key
		Collection<String> values = map.values();
		System.out.println(Arrays.toString(values.toArray()));
	}
}
