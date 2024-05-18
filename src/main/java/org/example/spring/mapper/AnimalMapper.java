package org.example.spring.mapper;

import org.example.spring.jdbc.AnimalDBPOJO;
import org.example.spring.model.Animal;
import org.example.spring.model.response.ResponseCreateAnimal;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AnimalMapper {

    public AnimalDBPOJO convertToAnimalDBPOJO(Animal animal) {
        AnimalDBPOJO animalDBPOJO = new AnimalDBPOJO();
        animalDBPOJO.setSizeAnimal(animal.getSizeAnimal());
        animalDBPOJO.setName(animal.getName());
        animalDBPOJO.setAge(animal.getAge());
        animalDBPOJO.setId(UUID.randomUUID().toString());
        return animalDBPOJO;
    }
    public ResponseCreateAnimal convertToResponseCreateAnimal(AnimalDBPOJO animal) {
        ResponseCreateAnimal responseCreateAnimal = new ResponseCreateAnimal();
        responseCreateAnimal.setId(animal.getId());
        return responseCreateAnimal;
    }
}
