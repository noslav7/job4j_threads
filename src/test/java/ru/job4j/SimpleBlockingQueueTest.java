package ru.job4j;

import org.junit.jupiter.api.Test;

class SimpleBlockingQueueTest {

    @Test
    void offer() {
        SimpleBlockingQueue<Integer> blockingQueue = new SimpleBlockingQueue<>();
        Thread thread1 = new Thread(
                () -> {
                    if (blockingQueue.poll().describeConstable().isEmpty()) {
                        try {
                            blockingQueue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                "Thread1"
        );
        Thread thread2 = new Thread(
                () -> {
                    if (blockingQueue.poll().describeConstable().isEmpty()) {
                        try {
                            blockingQueue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                "Thread2"
        );
        thread1.start();
        thread2.start();
    }

    @Test
    void poll() {
        SimpleBlockingQueue<Integer> blockingQueue = new SimpleBlockingQueue<>();
        Thread thread1 = new Thread(
                () -> {
                    if (blockingQueue.poll().describeConstable().isEmpty()) {
                        try {
                            blockingQueue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                "Thread1"
        );
        Thread thread2 = new Thread(
                () -> {
                    if (blockingQueue.poll().describeConstable().isEmpty()) {
                        try {
                            blockingQueue.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                "Thread2"
        );
        thread1.start();
        thread2.start();
    }
}