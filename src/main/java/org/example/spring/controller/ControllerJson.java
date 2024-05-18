package org.example.spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.spring.jdbc.AnimalDBPOJO;
import org.example.spring.jdbc.AnimalDao;
import org.example.spring.mapper.AnimalMapper;
import org.example.spring.model.Animal;
import org.example.spring.model.response.ResponseCreateAnimal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ControllerJson {
    private final AnimalDao animalDao;
    private final AnimalMapper animalMapper;


    @PostMapping(value = "json/animal/create")
    @ResponseBody
    public ResponseCreateAnimal createAnimal(@RequestBody Animal animal) {
        AnimalDBPOJO animalDBPOJO = animalMapper.convertToAnimalDBPOJO(animal);
        animalDao.createAnimal(animalDBPOJO);
        return animalMapper.convertToResponseCreateAnimal(animalDBPOJO);
    }
}
