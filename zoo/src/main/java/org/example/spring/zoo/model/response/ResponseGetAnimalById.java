package org.example.spring.zoo.model.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.spring.zoo.testing.finaltest.SizeAnimal;

@Data
@RequiredArgsConstructor
public class ResponseGetAnimalById {
    private String name;
    private int age;
    private SizeAnimal sizeAnimal;
    private String id;
}
