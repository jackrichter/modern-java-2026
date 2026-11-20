package com.eazybytes.java.multithreading;

import java.util.Random;

public class VirtualThreadDemo {

    static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Random random = new Random();

        Runnable runnable = () -> {
            double randomDouble = random.nextDouble(1000) * random.nextDouble(1000);
            System.out.println("Random double: " + randomDouble);
        };

        for (int i = 0; i < 500000; i++) {

            Thread.ofVirtual().start(runnable).join();       // 8059ms

//            Thread.startVirtualThread(runnable).join();    // 8048ms

//            Thread thread = new Thread(runnable);          // 72790ms
//            thread.start();
//            thread.join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime) + "ms");
    }
}
