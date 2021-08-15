package queue.concurrent;

import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) {
        // 基于 CAS 实现的无界线程安全队列
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        // 对于无界队列来说，添加元素都不会阻塞,所以用 add 和 offer 方法都是一样的
        queue.add(UUID.randomUUID().toString());
        queue.offer(UUID.randomUUID().toString());

        // 从队列中移除元素时，必须要考虑队列为空的情况
        // 队列为空时，直接抛 异常NoSuchElementException
        String element = queue.remove();
        System.out.println(element);

        // 队列为空，则返回 null
        String poll = queue.poll();
        System.out.println(poll);
    }
}
