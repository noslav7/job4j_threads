package ru.job4j;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class SimpleBlockingQueueTest {
/*
    @Test
    void offer() {
        SimpleBlockingQueue<Integer> blockingQueue = new SimpleBlockingQueue<>();
        int value = 100;
        Thread producer = new Thread(
                () -> {
                    blockingQueue.offer(value);
                },
                "Producer"
        );
        producer.start();
        SimpleBlockingQueue<Integer> expected = new SimpleBlockingQueue<>();
        expected.offer(100);
        assert(expected, blockingQueue);
    }

    @Test
    void poll() {
        SimpleBlockingQueue<Integer> blockingQueue = new SimpleBlockingQueue<>();
        int value = 100;
        Thread producer = new Thread(
                () -> {
                    blockingQueue.offer(value);
                },
                "Producer"
        );
        Thread consumer = new Thread(
                () -> {
                    try {
                        blockingQueue.poll();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },
                "Consumer"
        );
        producer.start();
        consumer.start();
        assert(blockingQueue.)
    }
    */
}