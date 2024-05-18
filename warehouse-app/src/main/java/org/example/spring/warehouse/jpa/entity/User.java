package org.example.spring.warehouse.jpa.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;
    private String role;
    @Column(name = "phone_number")
    private String phoneNumber;

    //связь без поля
    @OneToMany(mappedBy = "productProducer")
    private List<Product> productsProducer;

//    @OneToMany(mappedBy = "productConsumer")
//    private List<Product> productsConsumer;

}