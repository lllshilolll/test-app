package org.example.spring.zoo.testing.interfacetest;

public abstract class Present {

    private final String name;

    public Present(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();

    public void breath(){
        System.out.println("Present breath");
    }
}
