package org.example.threds.atomic;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicThread extends Thread {
    private final AtomicInteger atomicInteger;

    AtomicThread(String name, AtomicInteger atomicInteger) {
        super(name);
        this.atomicInteger = atomicInteger;
    }

    public void run() {
        try {
            for (int i = 0; i < 50; i++) {
                atomicInteger.incrementAndGet();
            }

        } catch (Exception e) {
            System.out.println("Thread has been interrupted");
        }
    }
}