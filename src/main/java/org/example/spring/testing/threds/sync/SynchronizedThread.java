package org.example.spring.testing.threds.sync;

class SynchronizedThread extends Thread {
    private final SynchronizedCounterWithLock synchronizedCounterWithLock;

    SynchronizedThread(String name, SynchronizedCounterWithLock synchronizedCounterWithLock) {
        super(name);
        this.synchronizedCounterWithLock = synchronizedCounterWithLock;
    }

    public void run() {
        try {
            for (int i = 0; i < 50; i++) {
                synchronizedCounterWithLock.increment();
            }
        } catch (Exception e) {
            System.out.println("Thread has been interrupted");
        }
    }
}