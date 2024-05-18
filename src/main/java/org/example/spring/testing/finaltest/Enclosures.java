package org.example.spring.testing.finaltest;

import lombok.Getter;

import java.util.*;


public class Enclosures extends Zoo {

    //в set не записываются повторы
    private final Set<AnimalTestFinal> smallEnclosure = new HashSet<>();
    private final Set<AnimalTestFinal> mediumEnclosure = new HashSet<>();
    private final Set<AnimalTestFinal> bigEnclosure = new HashSet<>();
    @Getter
    private final Queue<AnimalTestFinal> queue = new LinkedList<>();
    private final AnimalTestFinal[] animalTestFinalName = new AnimalTestFinal[10];

    @Override
    public void clean(AnimalTestFinal animal) {
        System.out.println("good clean area:" + animal.getName());
    }

    //нельзя переопределить final-метод
//    @Override
//    public void feedAnimal(AnimalTestFinal animal) {
//        System.out.println("good feed of "+ animal.getName());
//        Zoo.super.feedAnimal(animal);
//    }

    public void setAnimals(AnimalTestFinal animal) {
        try {

            for (AnimalTestFinal value : animalTestFinalName) {
                if (value != null && value.equals(animal)) {
                    return;
                }
            }
            animalTestFinalName[AnimalTestFinal.countAnimals - 1] = animal;
            //у final-объектов нельзя поменять ссылку на объект
            // animalName = new String[2];
            switch (animal.getSizeAnimal()) {
                case SMALL:
                    smallEnclosure.add(animal);
                case MEDIUM:
                    mediumEnclosure.add(animal);
                case BIG:
                    bigEnclosure.add(animal);
            }
        } catch (Exception e) {
            System.out.println("мест нет, животное " + animal.getName() + " добавлено в очередь");
            queue.add(animal);
        }
    }

    public void getEnclosures() {
        System.out.println("smallEnclosure: " + smallEnclosure.size());
        System.out.println("mediumEnclosure: " + mediumEnclosure.size());
        System.out.println("bigEnclosure: " + bigEnclosure.size());

        for (AnimalTestFinal animal : animalTestFinalName) {
            if (animal != null) {
                System.out.printf(animal.getName() + " ");
            }
        }
        System.out.println();
    }

}
