package org.example.finalmodifier;

public class Animal {
    private final String name;
    //final на примитивах - нельзя переопределить значение
    private final int age;
    private final SizeAnimal sizeAnimal;
    public static int countAnimals;

    public Animal(String name, int age, SizeAnimal sizeAnimal) {
        this.name = name;
        this.age = age;
        this.sizeAnimal = sizeAnimal;
        countAnimals++;
    }

    public void getInfoAboutAnimal() {
        System.out.println("Animal: name: " + name + " age: " + age + " sizeAnimal: " + sizeAnimal);
    }

    public SizeAnimal getSizeAnimal() {
        return sizeAnimal;
    }

    public String getName() {
        return name;
    }
}
