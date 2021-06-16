package queue;

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTest {

	/*
		Java 中有一个 PriorityQueue 容器类，表示优先级队列，利用它可以实现：

			1、求前K个最大的有元素，
			2、求中值元素

		Redis 中的 sorted set 数据结构就能够实现此功能

		堆是一种比较神奇的数据结构，概念上是树，存储为数组，父子有特殊顺序，根是最大值/最小值，
		构建/添加/删除效率都很高，可以高效解决很多问题
	 */
	public static void main(String[] args) {
		PriorityQueueTest obj = new PriorityQueueTest();
		obj.test1();
	}

	public void test1() {
		// 本质上就是一个使用数组实现的逻辑意义上的排序二叉树，并没有什么特别神奇的地方
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for (int i = 0; i < 10; i++) {
			int j = new Random().nextInt(100);
			priorityQueue.add(j);
		}
		// 直接这样遍历，并不是有序的，只有一个个取出来才是对的
		priorityQueue.forEach(System.out::println);
		System.out.println("---");
		for (int i = 0; i < priorityQueue.size(); i++) {
			System.out.println(priorityQueue.poll());
		}
	}
}
