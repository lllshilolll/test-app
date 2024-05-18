package org.example.spring.warehouse.jpa.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    private String id;

    @Column(name = "uniq_number_product")
    private String uniqNumberProduct;
    private String name;

    @ManyToOne
    @JoinColumn(name="producer_id", nullable=false)
    private User productProducer;

//    @ManyToOne
//    @JoinColumn(name="product_id", nullable=false)
//    @Column(name = "consumer_id")
//    private User productConsumer;

    @OneToOne
    private Warehouse warehouses;

}