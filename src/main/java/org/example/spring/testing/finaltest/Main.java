package org.example.spring.testing.finaltest;


public class Main {
    public static void main(String[] args) {
        //есть зоопарк - в нем ограниченное количество мест
        Enclosures enclosures = new Enclosures();

        //животные должны быть в вальере - один объект 1 вальер
        AnimalTestFinal elephant = new AnimalTestFinal("Jambo", 2, SizeAnimal.BIG);
        elephant.getInfoAboutAnimal();
        enclosures.setAnimals(elephant);

        AnimalTestFinal rabbit = new AnimalTestFinal("Bunny", 1, SizeAnimal.SMALL);
        rabbit.getInfoAboutAnimal();

        enclosures.setAnimals(rabbit);
        enclosures.setAnimals(elephant);
        AnimalTestFinal pig = new AnimalTestFinal("Hry", 3, SizeAnimal.MEDIUM);
        pig.getInfoAboutAnimal();

        enclosures.setAnimals(pig);


//        System.out.println("countAnimals: "+ Animal.countAnimals);
        enclosures.getEnclosures();

        enclosures.clean(elephant);
        enclosures.feedAnimal(elephant);
    }
}
