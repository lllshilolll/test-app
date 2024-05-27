package org.example.spring.warehouse.controllers;

import io.micrometer.core.annotation.Timed;
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

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserRestController implements UserApi {

    private final DataService dataService;


    @Timed("createUserProducts")
    @PreAuthorize("hasAuthority('admin')")
    @Override
    public ResponseEntity<String> createUserProducts(CreateUserProductsRequest createUserProductsRequest) {
        return ResponseEntity.ok(dataService.createUserProducts(createUserProductsRequest));
    }

    @Timed("getUserProducts")
    @PreAuthorize("hasAnyAuthority('user', 'admin')")
    @Override
    public ResponseEntity<List<Product>> getUserProducts() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(dataService.getUserProducts(auth.getName()));
    }

}
