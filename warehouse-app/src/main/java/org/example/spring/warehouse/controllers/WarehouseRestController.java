package org.example.spring.warehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.example.api.WarehouseApi;
import org.example.api.model.Warehouse;
import org.example.spring.warehouse.services.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WarehouseRestController implements WarehouseApi {

    private final DataService dataService;

    @Override
    public ResponseEntity<List<Warehouse>> getListWarehouse() {
        return ResponseEntity.ok(dataService.getListWarehouse());
    }
}
