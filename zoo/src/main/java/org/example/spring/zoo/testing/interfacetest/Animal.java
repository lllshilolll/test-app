package org.example.spring.zoo.testing.interfacetest;

public class Animal extends Mammals implements Walk, Swim {

    private final String name;

    public Animal(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void walk() {
        System.out.println(name + " walk");
    }

    @Override
    public void swim() {
        System.out.println(name + " swim");
    }

//    @Override
//    public String getDescription() {
//        return name + " Description";
//    }

    //default method in interface don't need to be overridden
    @Override
    public void run() {
        System.out.println(name + " run");
    }

    //not-abstract in abstract class method don't need to be overridden
    @Override
    public void breath() {
        System.out.println(name + " breath");
    }
}
