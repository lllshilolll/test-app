package org.example.spring.zoo.controller.view;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.spring.zoo.jdbc.AnimalDBPOJO;
import org.example.spring.zoo.mapper.AnimalMapper;
import org.example.spring.zoo.model.Animal;
import org.example.spring.zoo.jdbc.AnimalDao;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class ControllerModelAndView {

    private final AnimalDao animalDao;
    private final AnimalMapper animalMapper;


    @PostMapping(value = "view/animal/create")
    public ModelAndView createAnimal(@RequestBody Animal animal) {
        final var model = new ModelAndView("create_animal");
        AnimalDBPOJO animalDBPOJO = animalMapper.convertToAnimalDBPOJO(animal);
        log.info("Model: {}, animal: {}", model, animal);
        model.addObject("name", animalDBPOJO.getName());
        animalDao.createAnimal(animalDBPOJO);
        model.addObject("id", animalDBPOJO.getId());
        log.info("Model: {}", model);

        return model;
    }
}