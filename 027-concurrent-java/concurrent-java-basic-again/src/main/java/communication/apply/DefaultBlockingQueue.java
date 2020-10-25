package communication.apply;

import sun.awt.geom.AreaOp;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用 java.lang.Object 类的 wait() 和 notify() 方法实现一个阻塞队列（基于生产者，消费者模型）
 * 支持多生产者多消费者
 * @param <T>
 */
public class DefaultBlockingQueue<T> implements BlockingQueue<T> {

    private List<T> elements;

    public DefaultBlockingQueue(int capacity) {
        this.elements = new ArrayList<>(capacity);
    }

    private Object producer = new Object();
    private Object consumer = new Object();

    // 生产者线程的逻辑是，队列中的元素个数已经满了时，就必须处于阻塞状态(通知消费者赶紧消费)
    @Override
    public void put(T value) throws InterruptedException {
        
    }

    // 消费者线程的逻辑是，队列中的元素个数等于0时，就必须处于阻塞状态(通知生产者赶紧生产)
    @Override
    public T take() throws InterruptedException {
        return null;
    }
}
