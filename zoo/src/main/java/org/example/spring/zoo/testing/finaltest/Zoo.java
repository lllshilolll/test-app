package org.example.spring.zoo.testing.finaltest;

public class Zoo {

    public void clean(AnimalTestFinal animal) {
        System.out.println("clean area: " + animal.getName());
    }

    //нельзя переопределить final-метод
    public final void feedAnimal(AnimalTestFinal animal) {
        System.out.println("feed of " + animal.getName());
    }


}
