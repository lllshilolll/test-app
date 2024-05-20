package org.example.spring.warehouse.services;

import lombok.RequiredArgsConstructor;
import org.example.api.model.CreateUserProductsRequest;
import org.example.api.model.CreateUserRequest;
import org.example.api.model.Product;
import org.example.api.model.Warehouse;
import org.example.spring.warehouse.jpa.entity.Owner;
import org.example.spring.warehouse.jpa.entity.ProductEntity;
import org.example.spring.warehouse.jpa.entity.User;
import org.example.spring.warehouse.jpa.entity.WarehouseEntity;
import org.example.spring.warehouse.jpa.repository.*;
import org.example.spring.warehouse.mapper.WarehouseMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DataService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final WarehouseRepository warehouseRepository;
    private final OwnerRepository ownerRepository;
    private final WarehouseMapper mapper;

    @Transactional
    public List<Product> getOwnerProducts(String ownerId, String warehouseId) {
        Optional<Owner> owner = ownerRepository.findById(ownerId);
        if (owner.isPresent()) {
            Optional<WarehouseEntity> warehouse = warehouseRepository.findByOwnerAndWarehouseId(owner.get(), warehouseId);
            if (warehouse.isPresent()) {
                return mapper.convertToProductResponse(warehouse.get().getProductEntities());
            }
        }
        return null;
    }

    public String createUser(CreateUserRequest createUserRequest) {
        String userId = UUID.randomUUID().toString();
        User user = mapper.convertToUserEntity(createUserRequest, userId);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5);
        user.setPassword(encoder.encode(createUserRequest.getPassword()));
        return userRepository.save(user).getUserId();
    }

    public String createUserProducts(CreateUserProductsRequest createUserProductsRequest) {
        String productId = UUID.randomUUID().toString();
        ProductEntity product = mapper.convertToProductEntity(createUserProductsRequest, productId);
        Optional<User> user = userRepository.findById(createUserProductsRequest.getUserId());
        Optional<WarehouseEntity> warehouse = warehouseRepository.findById(createUserProductsRequest.getWarehouseId());
        user.ifPresent(product::setProductProducer);
        warehouse.ifPresent(product::setWarehouses);
        return productRepository.save(product).getId();
    }

    public List<Product> getUserProducts(String userName) {
        Optional<User> user = userRepository.findByName(userName);
        if (user.isPresent()) {
            List<ProductEntity> productEntities = productRepository.findByProductProducer(user.get());
            return mapper.convertToProductResponse(productEntities);
        }
        return null;
    }

    public List<Warehouse> getListWarehouse() {
        List<WarehouseEntity> warehouseEntities = warehouseRepository.findAll();
        return mapper.convertToWarehouseResponse(warehouseEntities);
    }

}
