package org.example.spring.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.spring.testing.finaltest.SizeAnimal;

@Data
//@AllArgsConstructor
@RequiredArgsConstructor
public class AnimalDBPOJO {
    private String name;
    private int age;
    private SizeAnimal sizeAnimal;
    private String id;

//    public AnimalDBPOJO(String name, int age, SizeAnimal sizeAnimal, String id) {
//        this.name = name;
//        this.age = age;
//        this.sizeAnimal = sizeAnimal;
//        this.id = id;
//    }
}
