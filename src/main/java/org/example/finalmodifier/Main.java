package org.example.finalmodifier;


import static org.example.finalmodifier.Animal.countAnimals;

public class Main {
    public static void main(String[] args) {
        //есть зоопарк - в нем ограниченное количество мест
        Enclosures enclosures = new Enclosures();

        //животные должны быть в вальере - один объект 1 вальер
        Animal elephant = new Animal("Jambo", 2, SizeAnimal.BIG);
        elephant.getInfoAboutAnimal();
        enclosures.setAnimals(elephant);

        Animal rabbit = new Animal("Bunny", 1, SizeAnimal.SMALL);
        rabbit.getInfoAboutAnimal();

        enclosures.setAnimals(rabbit);
        enclosures.setAnimals(elephant);
        Animal pig = new Animal("Hry", 3, SizeAnimal.MEDIUM);
        pig.getInfoAboutAnimal();

        enclosures.setAnimals(pig);


        System.out.println("countAnimals: "+ countAnimals);
        enclosures.getEnclosures();

        enclosures.clean(elephant);
        enclosures.feedAnimal(elephant);
    }
}
