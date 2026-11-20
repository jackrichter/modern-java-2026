package com.eazybytes.java.multithreading;

public class SharedBooleanResource {

    private volatile boolean stopFlag = false;

    public void setStopFlag() {
        this.stopFlag = true;
    }

    public void doWork() {
        while (stopFlag == false) {
            System.out.println("Doing work");
        }
        System.out.println("Work stopped");
    }
}
