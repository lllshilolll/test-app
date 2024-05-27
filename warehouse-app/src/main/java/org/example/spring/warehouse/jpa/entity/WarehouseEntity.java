package org.example.spring.warehouse.jpa.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "warehouses")
@Data
public class WarehouseEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private String warehouseId;
    private String city;
    private String country;
    private Integer size;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "warehouses")
    private List<ProductEntity> productEntities;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;


}