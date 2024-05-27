package org.example.spring.zoo.testing.threds.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperation {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        AtomicInteger atomicInteger = new AtomicInteger();
        List<AtomicThread> atomicThreads = new ArrayList<>();

        //создание побочного потока
        for (int i = 0; i < 50; i++) {
            AtomicThread atomicThread = new AtomicThread("AtomicThread " + i, atomicInteger);
            atomicThreads.add(atomicThread);
            atomicThread.start();
        }

        try {
            for (AtomicThread atomicThread : atomicThreads) {
                atomicThread.join();
                System.out.println("thread " + atomicThread.getName() + " joined...");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        long endTime = System.nanoTime();

        System.out.println("Nano: " + (endTime - startTime));
        //107191823 no sync
        //98006379 sync
        //58412169 atomic

        System.out.println("Main thread finished... " + atomicInteger);

    }
}
