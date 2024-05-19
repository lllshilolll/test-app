package org.example.spring.warehouse.jpa.repository;

import org.example.spring.warehouse.jpa.entity.Owner;
import org.example.spring.warehouse.jpa.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, String> {

    Optional<Warehouse> findByOwnerAndWarehouseId(Owner owner, String warehouseId);
}