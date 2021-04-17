package map;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author keqi
 */
public class EnumMapTest {

	public static void main(String[] args) {
		// 如果希望一个 Map 的类型是枚举类型的话，可以使用 EnumMap

		EnumMap<GenderEnum, String> enumMap = new EnumMap<>(GenderEnum.class);

		enumMap.put(GenderEnum.MAN, GenderEnum.MAN.getCodeName());
		enumMap.put(GenderEnum.WOMEN, GenderEnum.WOMEN.getCodeName());

		for (Map.Entry<GenderEnum, String> entry : enumMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		System.out.println("======");

		// 使用普通 HashMap 的方式存储枚举类型也是可以的，只不过效率会稍微低一点，明白吗？

		HashMap<GenderEnum, String> hashMap = new HashMap<>();

		hashMap.put(GenderEnum.MAN, GenderEnum.MAN.getCodeName());
		hashMap.put(GenderEnum.WOMEN, GenderEnum.WOMEN.getCodeName());

		for (Map.Entry<GenderEnum, String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}


		/*
			集合中需要重点掌握的有以下几个：
				1、ArrayList LinkedList
				2、HashMap TreeMap LinkedHashMap EnumMap


				3、每一个 xxxSet 都是 基于对应的 xxxMap 实现的，掌握了 Map 的实现原理，其实就掌握了 Set
		*/
	}
}
