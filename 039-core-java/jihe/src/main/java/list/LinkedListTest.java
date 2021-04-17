package list;


import java.util.LinkedList;

/**
 * @author keqi
 */
public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<>();


		// LinkedList 本质上是一个双向链表，基于这个双向链表可以构造出队列、栈、双向队列这种特殊类型的数据结构

		// 构造队列
		linkedList.offer("1");
		linkedList.offer("2");
		linkedList.offer("3");
		linkedList.offer("4");

		// 输出的是 1
		System.out.println(linkedList.peek());


		// 构造栈
		// 输出的是 4
		System.out.println(linkedList.peekLast());
	}
}
