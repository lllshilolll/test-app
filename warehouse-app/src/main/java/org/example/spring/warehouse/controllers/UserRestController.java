package org.example.spring.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.example.api.UserApi;
import org.example.api.model.CreateUserProductsRequest;
import org.example.api.model.Product;
import org.example.spring.warehouse.services.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserRestController implements UserApi {

    private final DataService dataService;

    @GetMapping("/")
    public String get() {
        return "Hello";
    }

    @PreAuthorize("hasAuthority('admin')")
    @Override
    public ResponseEntity<String> createUserProducts(CreateUserProductsRequest createUserProductsRequest) {
        return ResponseEntity.ok(dataService.createUserProducts(createUserProductsRequest));
    }

    @PreAuthorize("hasAnyAuthority('user', 'admin')")
    @Override
    public ResponseEntity<List<Product>> getUserProducts() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(dataService.getUserProducts(auth.getName()));
    }

}
