package list;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author keqi
 */
public class LinkedListTest {

	/*
		LinkedList 的底层实现是双向链表，基于此种数据结构，它可以被用作单向队列、双向队列、栈
			它实现了 List 和 Deque 接口
	 */

	public static void main(String[] args) {
		LinkedListTest obj = new LinkedListTest();
		obj.test3();
	}

	public void test1() {
		/*
		 LinkedList 实现了 Queue 接口，它的主要操作有三个：
		    在尾部添加元素： add（队列已经满了时，会抛出 IllegalStateException） offer 则只会返回 false
			查看头部元素： element（队列为空时，会抛出 NoSuchElementException） peek 则只会返回 null
			删除头部元素：remove(队列为空时，会抛出 NoSuchElementException) poll 则只会返回 null
		 */
		Queue<String> queue = new LinkedList<>();
		queue.add("a");
		queue.add("b");
		queue.offer("c");

		while (queue.peek() != null) {
			String poll = queue.poll();
			System.out.println(poll);
		}
	}

	public void test2() {
		LinkedList<String> linkedList = new LinkedList<>();


		// LinkedList 本质上是一个双向链表，基于这个双向链表可以构造出队列、栈、双向队列这种特殊类型的数据结构

		// 构造队列
		linkedList.offer("1");
		linkedList.offer("2");
		linkedList.offer("3");
		linkedList.offer("4");

		// 输出的是 1
		System.out.println(linkedList.peek());

		String s = linkedList.get(2);
		// 构造栈
		// 输出的是 4
		System.out.println(linkedList.peekLast());
	}

	public void test3() {
		/*
			Java 中没有单独的栈接口，栈相关接口包括在了表示双端队列的接口Deque，主要有三个方法：

			1、push 在头部添加元素，如果栈的空间满了，就会抛出 IllegalStateException
			2、pop 在头部删除元素，如果栈为空，就会抛出 NoSuchElementException
			3、peek 查看栈头部元素，不修改栈，如果栈为空，则返回 null

		 */
		Deque<Integer> stack = new LinkedList<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		while (stack.size() > 0) {
			Integer pop = stack.pop();
			System.out.println(pop);
		}

		// Queue 只是单向队列，Deque 则是双向队列，提供了很多直观的方法来进行首尾操作
		/*
			xxxFirst 操作头部，xxxLast 操作尾部
			getXXX/removeXXX 在队列为空时，会抛出异常
			peekXXX/pollXXX 在队列为空时，只会返回 null



		 */
	}
}
