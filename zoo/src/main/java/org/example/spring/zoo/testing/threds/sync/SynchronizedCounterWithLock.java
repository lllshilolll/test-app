package org.example.spring.zoo.testing.threds.sync;

public class SynchronizedCounterWithLock {
    //volatile - любые изменения, внесенные в переменную, будут немедленно видны всем потокам
    public volatile int count;

    //synchronized - только один поток будет обращаться к методу единовременно
    public synchronized void increment() {
        count++;
        System.out.println(count);
    }

    //одновременный доступ к переменной
//    public  int count;
//
//    public  void increment() {
//        count++;
//        System.out.println(count);
//    }

}
