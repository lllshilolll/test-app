package org.example.spring.warehouse.services;

import lombok.RequiredArgsConstructor;
import org.example.spring.warehouse.jpa.entity.Owner;
import org.example.spring.warehouse.jpa.entity.ProductEntity;
import org.example.spring.warehouse.jpa.entity.Warehouse;
import org.example.spring.warehouse.jpa.repository.*;
import org.example.spring.warehouse.mapper.WarehouseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DataService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final WarehouseRepository warehouseRepository;
    private final OwnerRepository ownerRepository;
    private final WarehouseMapper mapper;

    @Transactional
    public List<org.example.api.model.Product> getOwnerProducts(String ownerId, String warehouseId) {
        Optional<Owner> owner = ownerRepository.findById(ownerId);
        if (owner.isPresent()) {
            Optional<Warehouse> warehouse = warehouseRepository.findByOwnerAndWarehouseId(owner.get(), warehouseId);
            if (warehouse.isPresent()) {
                return mapper.convertToProductResponse(warehouse.get().getProductEntities());
            }
        }
        return null;

    }

    public Optional<ProductEntity> getProductById(String productId) {
        return productRepository.findById(productId);
    }
}
