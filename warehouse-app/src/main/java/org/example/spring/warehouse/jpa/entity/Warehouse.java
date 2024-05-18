package org.example.spring.warehouse.jpa.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "warehouses")
@Data
public class Warehouse {
    @Id
    @Column(name = "warehouse_id")
    private String warehouseId;
    private String city;
    private String country;
    private Integer size;
    private String phoneNumber;


}