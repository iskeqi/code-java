package map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	/*
		LinkedHashMap 是 HashMap 的子类，内部有一个LinkedList来维护键值对的顺序，能够实现：

			1、按照元素的插入(put())顺序进行排序
				如果希望能够有Map的按照key取数据的特性，又希望能够按照插入顺序进行排序可用此种容器
			2、按照元素的访问(get()和put())顺序进行排序
				最典型的应用案例就是LRU了，能够实现最近最常访问的排在后面，不长访问的排在前面

	 */

	public static void main(String[] args) {
		LinkedHashMapTest obj = new LinkedHashMapTest();
		obj.test2();
	}

	public void test1() {
		// 默认情况下，LinkedHashMap 没有对容量做限制，必须要通过继承这个类，
		// 然后重写 removeEldestEntry() 方法来实现LRU缓存
	}

	public void test2() {
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("a", "a");
		linkedHashMap.put("b", "b");
		linkedHashMap.put("c", "c");
		linkedHashMap.put("d", "d");

		for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}
	}
}
