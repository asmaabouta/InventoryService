package com.asmaa.inventoryservice.mappers;
import com.asmaa.inventoryservice.dto.ProductRequestDTO;
import com.asmaa.inventoryservice.dto.ProductRespenseDTO;
import com.asmaa.inventoryservice.entities.Product;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductRespenseDTO productToProductDTO(Product product);
    Product ProductDTOToProduct(ProductRequestDTO productRequestDTO);
}
