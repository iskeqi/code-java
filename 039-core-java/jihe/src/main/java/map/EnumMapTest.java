package map;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author keqi
 */
public class EnumMapTest {

	/*
		如果 key 是枚举类型的话，是可以使用 HashMap 实现的。但是因为枚举类型有如下特点：
			1、它的值都是预先就已经定义好了（完全可以通过反射API获取到）
			2、每一个枚举对象都有一个对应的 ordinary 值，是排序的
		基于以上特点，可以实现一个效率更高的 Map 容器。

		它的实现原理是，维护了两个数组，一个存储Key，一个存储value
		都是通过枚举对象的ordinary属性值，来作为数组的下标，利用了数组索引下标查询速度快的特性实现的Map结构
		而且数组的长度还可以在对象初始化的时候就事先确定好！
			这种方式非常的讨巧，非常的合适。这速度比哈希表快多了
	 */



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
