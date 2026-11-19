package com.eazybytes.java.multithreading;

public class ProducerConsumerDemo {
    
    static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Producer Thread
        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                sharedResource.produce(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producerThread.start();

        // Consumer Thread
        Thread consumerThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                sharedResource.consume();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        consumerThread.start();
    }
}
