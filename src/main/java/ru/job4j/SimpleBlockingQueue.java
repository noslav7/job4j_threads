package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    private int max_size;
    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();

    public SimpleBlockingQueue(int max_size) {
        this.max_size = max_size;
    }

    public synchronized void offer(T value) throws InterruptedException {
        while (queue.size() == max_size) {
            wait();
        }
        queue.offer(value);
        notify();
    }

    public synchronized T poll() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        T removedElement = queue.peek();
        notify();
        return removedElement;
    }
}
