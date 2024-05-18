package org.example.spring.warehouse.jpa.repository;

import org.example.spring.warehouse.jpa.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, String>{

}