package org.example.spring.zoo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.spring.zoo.jdbc.AnimalDBPOJO;
import org.example.spring.zoo.jdbc.AnimalDao;
import org.example.spring.zoo.mapper.AnimalMapper;
import org.example.spring.zoo.model.Animal;
import org.example.spring.zoo.model.response.ResponseCreateAnimal;
import org.example.spring.zoo.model.response.ResponseGetAnimalById;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ControllerJson {
    private final AnimalDao animalDao;
    private final AnimalMapper animalMapper;

    @PostMapping(value = "json/animal/create")
    public ResponseCreateAnimal createAnimal(@RequestBody Animal animal) {
        AnimalDBPOJO animalDBPOJO = animalMapper.convertToAnimalDBPOJO(animal);
        animalDao.createAnimal(animalDBPOJO);
        return animalMapper.convertToResponseCreateAnimal(animalDBPOJO);
    }

    @GetMapping(value = "json/animal")
    public ResponseGetAnimalById getAnimalById(@RequestParam String id) {
        AnimalDBPOJO animalDBPOJO = animalDao.findById(id);
        return animalMapper.convertResponseGetAnimalById(animalDBPOJO);
    }

    @GetMapping(value = "json/animal/list")
    public List<ResponseGetAnimalById> getAnimals() {
        List<AnimalDBPOJO> animalDBPOJOS = animalDao.findAll();
        return animalDBPOJOS.stream()
                .map(animalMapper::convertResponseGetAnimalById)
                .collect(Collectors.toList());
    }
}
