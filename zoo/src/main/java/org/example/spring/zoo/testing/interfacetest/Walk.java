package org.example.spring.zoo.testing.interfacetest;

public interface Walk {

    void walk();

    default void run() {
        System.out.println("Walk run");
    }
}
