package org.example.spring.warehouse.services;

import lombok.RequiredArgsConstructor;
import org.example.spring.warehouse.jpa.entity.Product;
import org.example.spring.warehouse.jpa.repository.ProductRepository;
import org.example.spring.warehouse.jpa.repository.UserRepository;
import org.example.spring.warehouse.jpa.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DataService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final WarehouseRepository warehouseRepository;

    public Optional<Product> getProductById(String productId) {
        return productRepository.findById(productId);
    }
}
