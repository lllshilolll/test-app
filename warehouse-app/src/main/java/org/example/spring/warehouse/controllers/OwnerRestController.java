package org.example.spring.warehouse.controllers;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.example.api.OwnerApi;
import org.example.api.model.CreateUserRequest;
import org.example.api.model.Product;
import org.example.spring.warehouse.services.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OwnerRestController implements OwnerApi {

    private final DataService dataService;

    @Timed("getOwnerProducts")
    @Override
    public ResponseEntity<List<Product>> getOwnerProducts(String ownerId, String warehouseId) {
        return ResponseEntity.ok(dataService.getOwnerProducts(ownerId, warehouseId));
    }

    @Timed("createUser")
    @Override
    public ResponseEntity<String> createUser(CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(dataService.createUser(createUserRequest));
    }
}
