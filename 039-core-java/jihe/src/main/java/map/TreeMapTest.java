package map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

	/*
		TreeMap 内部是用红黑树实现的，红黑树就是一个大致平衡的排序二叉树


	 */



	public static void main(String[] args) {
		TreeMapTest obj = new TreeMapTest();
		obj.test1();
	}

	public void test1() {
		TreeMap<String, String> treeMap = new TreeMap<>(/*Collections.reverseOrder()*/);
		treeMap.put("a", "a");
		treeMap.put("b", "b");
		treeMap.put("c", "c");
		treeMap.put("d", "d");

		Map.Entry<String, String> lastEntry = treeMap.lastEntry();
		System.out.println(lastEntry.getKey() + "->" + lastEntry.getValue());

		Map.Entry<String, String> firstEntry = treeMap.firstEntry();
		System.out.println(firstEntry.getKey() + "->" + firstEntry.getValue());

		for (Map.Entry<String, String> entry : treeMap.entrySet()) {
			// 遍历时就是按照从小到大的方式进行排序的
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}

		boolean a = treeMap.containsKey("a");
		System.out.println(a);
	}
}
