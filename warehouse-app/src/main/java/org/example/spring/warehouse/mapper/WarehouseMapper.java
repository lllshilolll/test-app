package org.example.spring.warehouse.mapper;

import org.example.api.model.CreateUserProductsRequest;
import org.example.api.model.CreateUserRequest;
import org.example.api.model.Product;
import org.example.api.model.Warehouse;
import org.example.spring.warehouse.jpa.entity.ProductEntity;
import org.example.spring.warehouse.jpa.entity.User;
import org.example.spring.warehouse.jpa.entity.WarehouseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface WarehouseMapper {
    @Mapping(target = "uniqProductId", source = "productEntityList.uniqNumberProduct")
    @Mapping(target = "warehouseId", source = "productEntityList.warehouses.warehouseId")
    @Mapping(target = "producerId", source = "productEntityList.productProducer.userId")
    Product convertToProductResponse(ProductEntity productEntityList);

    List<Product> convertToProductResponse(List<ProductEntity> productEntityList);

    @Mapping(target = "productsProducer", ignore = true)
    @Mapping(target = "password", ignore = true)
    User convertToUserEntity(CreateUserRequest request, String userId);

    @Mapping(target = "id", source = "productId")
    @Mapping(target = "uniqNumberProduct", source = "request.uniqProductId")
    @Mapping(target = "productProducer", ignore = true)
    @Mapping(target = "warehouses", ignore = true)
    ProductEntity convertToProductEntity(CreateUserProductsRequest request, String productId);

    @Mapping(target = "ownerId", source = "owner.ownerId")
    Warehouse convertToWarehouseResponse(WarehouseEntity warehouseEntity);

    List<Warehouse> convertToWarehouseResponse(List<WarehouseEntity> warehouseEntities);

}
