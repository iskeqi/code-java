package communication.apply;

public interface BlockingQueue<T> {

    void put(T value) throws InterruptedException;

    T take() throws InterruptedException;
}
