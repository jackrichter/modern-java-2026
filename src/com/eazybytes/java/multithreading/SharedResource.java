package com.eazybytes.java.multithreading;

public class SharedResource {

    private int data;   // Shared resource
    private boolean isEmpty = true;

    // Producer method
    synchronized void produce(int value) {
        // Condition for Producer to wait for Consumer to consume
        while (isEmpty == false) {
            try {
                // Buffer is not empty, wait for the consumer to consume
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Produce data
        this.data = value;
        System.out.println("Produced: " + value);

        // Allow Consumer to work
        isEmpty = false;
        notify();
    }

    // Consumer method
    synchronized int consume() {
        // Condition for Consumer to wait for Producer to produce
        while (isEmpty == true) {
            try {
                // Buffer is empty, wait for the producer to produce
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Consume data
        int consumedData = this.data;
        System.out.println("Consumed: " + consumedData);

        // Allow Producer to work
        isEmpty = true;
        notify();

        return consumedData;
    }
}
