package com.eazybytes.java.multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Semaphores handle concurrence with multiple threads.
 * acquire (== wait)
 * release (== notify)
 */
public class ProducerConsumerSemaphoreDemo {

    static void main(String[] args) {
        Queue<Object> store = new ArrayDeque<>();
        int capacity = 10;

        Semaphore producerSemaphore = new Semaphore(capacity);
        Semaphore consumerSemaphore = new Semaphore(0);

        SharedResourceSemaphore sharedResource1 = new SharedResourceSemaphore(store, "P1", "C1",
                producerSemaphore, consumerSemaphore);

        SharedResourceSemaphore sharedResource2 = new SharedResourceSemaphore(store, "P2", "C2",
                producerSemaphore, consumerSemaphore);

        // Producer1 Thread
        Thread prod1Thread = new Thread(() -> {
            for (int i = 1; i <= capacity; i++) {
                sharedResource1.produce(new Object());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Producer2 Thread
        Thread prod2Thread = new Thread(() -> {
            for (int i = 1; i <= capacity; i++) {
                sharedResource2.produce(new Object());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Consumer1 Thread
        Thread consumer1Thread = new Thread(() -> {
            for (int i = 1; i <= capacity; i++) {
                sharedResource1.consume();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Consumer2 Thread
        Thread consumer2Thread = new Thread(() -> {
            for (int i = 1; i <= capacity; i++) {
                sharedResource2.consume();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        prod1Thread.start();
        prod2Thread.start();
        consumer1Thread.start();
        consumer2Thread.start();
    }
}
