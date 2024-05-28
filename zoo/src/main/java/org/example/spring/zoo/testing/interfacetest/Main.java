package org.example.spring.zoo.testing.interfacetest;


public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("fox");
        animal.run();
        animal.walk();
        animal.swim();

        System.out.println();

        Animal cat = new Animal("cat");
        cat.breath();
        cat.be();
        System.out.println(cat.getDescription());

        System.out.println();

        Mammals mammal = new Mammals("mammal");
        mammal.breath();
        System.out.println(mammal.getDescription());
        mammal.be();

    }
}
