package org.example.spring.warehouse.jpa.repository;

import org.example.spring.warehouse.jpa.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, String> {
}