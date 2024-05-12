package org.example.finaltest;

import java.util.*;

import static org.example.finaltest.Animal.countAnimals;


public class Enclosures extends Zoo {

    //в set не записываются повторы
    private final Set<Animal> smallEnclosure = new HashSet<>();
    private final Set<Animal> mediumEnclosure = new HashSet<>();
    private final Set<Animal> bigEnclosure = new HashSet<>();
    private final Queue<Animal> queue = new LinkedList<>();
    private final Animal[] animalName = new Animal[10];

    @Override
    public void clean(Animal animal) {
        System.out.println("good clean area:" + animal.getName());
    }

    //нельзя переопределить final-метод

//    @Override
//    public void feedAnimal(Animal animal) {
//        System.out.println("good feed of "+ animal.getName());
//        Zoo.super.feedAnimal(animal);
//    }

    public void setAnimals(Animal animal) {
        try {

            for (Animal value : animalName) {
                if (value != null && value.equals(animal)) {
                    return;
                }
            }
            animalName[countAnimals - 1] = animal;
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

        for (Animal animal : animalName) {
            if (animal != null) {
                System.out.printf(animal.getName() + " ");
            }
        }
        System.out.println();
    }

    public Queue<Animal> getQueue() {
        return queue;
    }
}
