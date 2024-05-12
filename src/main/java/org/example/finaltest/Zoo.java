package org.example.finaltest;

public class Zoo {

    public void clean(Animal animal) {
        System.out.println("clean area: " + animal.getName());
    }

    //нельзя переопределить final-метод
    public final void feedAnimal(Animal animal) {
        System.out.println("feed of " + animal.getName());
    }


}
