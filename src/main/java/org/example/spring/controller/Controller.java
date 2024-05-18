package org.example.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.spring.model.Animal;
import org.example.spring.jdbc.AnimalDao;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@org.springframework.stereotype.Controller
public class Controller {

    private final AnimalDao animalDao;

    public Controller(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @PostMapping(value = "/animal/create")
    public ModelAndView createAnimal(@RequestBody Animal animal) {
        final var model = new ModelAndView("create_animal");

        log.info("Model: {}, animal: {}", model, animal.toString());
        model.addObject("name", animal.getName());
        model.addObject("id", animalDao.createAnimal(animal));
        log.info("Model: {}", model);

        return model;
    }
}