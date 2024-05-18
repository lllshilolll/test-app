package org.example.spring.model.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.spring.testing.finaltest.SizeAnimal;

@Data
@RequiredArgsConstructor
public class ResponseGetAnimalById {
    private String name;
    private int age;
    private SizeAnimal sizeAnimal;
    private String id;
}
