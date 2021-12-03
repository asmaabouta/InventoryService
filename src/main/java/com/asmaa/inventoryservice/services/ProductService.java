package com.asmaa.inventoryservice.services;

import com.asmaa.inventoryservice.dto.ProductRequestDTO;
import com.asmaa.inventoryservice.dto.ProductRespenseDTO;

import java.util.List;

public interface ProductService {
    ProductRespenseDTO save(ProductRequestDTO productRequestDTO);
    ProductRespenseDTO getProduct(String id);
    ProductRespenseDTO update(ProductRequestDTO productRequestDTO);
    List<ProductRespenseDTO> getAllProducts();
}
