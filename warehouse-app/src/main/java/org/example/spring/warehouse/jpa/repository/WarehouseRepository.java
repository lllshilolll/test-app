package org.example.spring.warehouse.jpa.repository;

import org.example.spring.warehouse.jpa.entity.Owner;
import org.example.spring.warehouse.jpa.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity, String> {

    Optional<WarehouseEntity> findByOwnerAndWarehouseId(Owner owner, String warehouseId);
}