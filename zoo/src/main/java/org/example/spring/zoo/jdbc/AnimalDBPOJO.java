package org.example.spring.zoo.jdbc;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.spring.zoo.testing.finaltest.SizeAnimal;

@Data
@RequiredArgsConstructor
public class AnimalDBPOJO {
    private String name;
    private int age;
    private SizeAnimal sizeAnimal;
    private String id;

}
