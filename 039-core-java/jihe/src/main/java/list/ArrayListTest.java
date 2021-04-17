package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * ArrayListTest
 *
 * @author keqi
 */
public class ArrayListTest {

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		ArrayList<String> strList = new ArrayList<>();
		strList.add("老马");
		strList.add("编程");

		strList.remove("老马");

		Iterator<String> iterator = strList.iterator();
		ListIterator<String> listIterator = strList.listIterator(); // 针对 List 进行了一些功能的增强
		while (iterator.hasNext()) {

			String next = iterator.next();
			System.out.println(next);
			//strList.remove(next); // 这行代码会报错
		}

		// 增强 for 循环只是一种语法糖，本质上是调用了 iterator 方法得到了 iterator 对象，然后进行遍历
		// 迭代器在 for 循环的过程中不能够对容器进行增加、删除、修改元素内容是可以的，因为这不属于容器的结构性变化

		// 那，如果我就是需要在遍历容器的过程中，对容器中的元素进行删除呢？可以使用 iterator 中实现的 remove 方法

		/*for (String str : strList) {
			System.out.println(str);
		}*/
	}
}
