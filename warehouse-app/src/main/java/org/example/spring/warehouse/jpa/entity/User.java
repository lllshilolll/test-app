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
    private String name;
    private String password;

    @OneToMany(mappedBy = "productProducer")
    private List<ProductEntity> productsProducer;

}