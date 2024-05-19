package org.example.spring.warehouse.jpa.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owners")
@Data
public class Owner {
    @Id
    @Column(name = "owner_id")
    private String ownerId;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String name;

    @OneToMany(mappedBy = "owner")
    private List<Warehouse> warehouses;

}