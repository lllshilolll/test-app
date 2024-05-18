package org.example.spring.zoo.model;

import lombok.Getter;
import lombok.ToString;
import org.example.spring.zoo.testing.finaltest.SizeAnimal;

@Getter
@ToString
public class Animal {
    private final String name;
    private final int age;
    private final SizeAnimal sizeAnimal;

    public Animal(String name, int age, SizeAnimal sizeAnimal) {
        this.name = name;
        this.age = age;
        this.sizeAnimal = sizeAnimal;
    }

    public void getInfoAboutAnimal() {
        System.out.println("Animal: name: " + name + " age: " + age + " sizeAnimal: " + sizeAnimal);
    }

}
