package org.example.threds.sync;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedOperation {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        SynchronizedCounterWithLock synchronizedCounterWithLock = new SynchronizedCounterWithLock();
        List<SynchronizedThread> synchronizedThreads = new ArrayList<>();

        //создание побочного потока
        for (int i = 0; i < 50; i++) {
            SynchronizedThread synchronizedThread = new SynchronizedThread("JThread " + i, synchronizedCounterWithLock);
            synchronizedThreads.add(synchronizedThread);
            synchronizedThread.start();
        }

        try {
            for (SynchronizedThread synchronizedThread : synchronizedThreads) {
                synchronizedThread.join();
                System.out.println("thread " + synchronizedThread.getName() + " joined...");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        long endTime = System.nanoTime();

        System.out.println("Nano: " + (endTime - startTime));
        //107191823 no sync
        //98006379 sync

        System.out.println("Main thread finished... " + synchronizedCounterWithLock.count);
    }
}
