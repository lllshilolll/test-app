package org.example.spring.zoo.testing.interfacetest;

public class Mammals extends Present {

    public Mammals(String name) {
        super(name);
    }

    public void be() {
        System.out.println("Mammals be");
    }

    @Override
    public String getDescription() {
        return "Mammals description";
    }
}
