package com.eazybytes.java.multithreading;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class SharedResourceSemaphore {

    private final Queue<Object> store;
    private final String prodName;
    private final String consumerName;
    private final Semaphore produceSemaphore;
    private final Semaphore consumeSemaphore;

    public SharedResourceSemaphore(Queue<Object> store, String prodName, String consumerName,
                                   Semaphore produceSemaphore, Semaphore consumeSemaphore) {
        this.store = store;
        this.prodName = prodName;
        this.consumerName = consumerName;
//        this.capacity = capacity;
        this.produceSemaphore = produceSemaphore;
        this.consumeSemaphore = consumeSemaphore;
    }

    // Producer
    public void produce(Object item) {
        while (true) {
            try {
                produceSemaphore.acquire();     // Acquire a permit to produce
                store.add(item);                // Produce an item
                System.out.println("Producer " + prodName + " produced an item. Queue size: " + (store.size() + 1));
                consumeSemaphore.release();     // Consumer can consume now
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Consumer
    public void consume() {
        while (true) {
            try {
                consumeSemaphore.acquire();     // Acquire a permit to consume
                store.remove();                // Consume an item
                System.out.println("Consumer " + consumerName + " consumed an item. Queue size: " + (store.size() - 1));
                produceSemaphore.release();    // Producer can produce now
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
