package org.example.spring.zoo.testing.finaltest;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AnimalTestFinal {
    private final String name;
    //final на примитивах - нельзя переопределить значение
    private final int age;
    private final SizeAnimal sizeAnimal;
    public static int countAnimals;

    public AnimalTestFinal(String name, int age, SizeAnimal sizeAnimal) {
        this.name = name;
        this.age = age;
        this.sizeAnimal = sizeAnimal;
        countAnimals++;
    }

    public void getInfoAboutAnimal() {
        System.out.println("Animal: name: " + name + " age: " + age + " sizeAnimal: " + sizeAnimal);
    }

}
