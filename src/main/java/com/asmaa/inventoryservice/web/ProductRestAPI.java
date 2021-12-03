package com.asmaa.inventoryservice.web;

import com.asmaa.inventoryservice.dto.ProductRequestDTO;
import com.asmaa.inventoryservice.dto.ProductRespenseDTO;
import com.asmaa.inventoryservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class ProductRestAPI {
    private ProductService productService;

    public ProductRestAPI(ProductService productService){
        this.productService=productService;
    }
    @GetMapping(path = "/products")
    public List<ProductRespenseDTO> allProducts(){
        return productService.getAllProducts();
    }

    @PostMapping(path = "/products")
    public ProductRespenseDTO save(@RequestBody ProductRequestDTO productRequestDTO){
        productRequestDTO.setId(UUID.randomUUID().toString());
        return productService.save(productRequestDTO);
    }
    @GetMapping(path = "/products/{id}")
    public ProductRespenseDTO getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }
}
