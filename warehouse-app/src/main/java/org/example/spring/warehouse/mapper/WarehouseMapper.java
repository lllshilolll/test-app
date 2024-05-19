package org.example.spring.warehouse.mapper;

import org.example.api.model.Product;
import org.example.spring.warehouse.jpa.entity.ProductEntity;
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

}
