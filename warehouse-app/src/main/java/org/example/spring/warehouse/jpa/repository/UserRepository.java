package org.example.spring.warehouse.jpa.repository;

import org.example.spring.warehouse.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>{


    Optional<User> findByName(String name);
}