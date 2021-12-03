package com.asmaa.inventoryservice.services;

import com.asmaa.inventoryservice.dto.ProductRequestDTO;
import com.asmaa.inventoryservice.dto.ProductRespenseDTO;
import com.asmaa.inventoryservice.entities.Product;
import com.asmaa.inventoryservice.mappers.ProductMapper;
import com.asmaa.inventoryservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    @Override
    public ProductRespenseDTO save(ProductRequestDTO productRequestDTO) {
        Product product=productMapper.ProductDTOToProduct(productRequestDTO);
        Product saveProduct=productRepository.save(product);
        ProductRespenseDTO productRespenseDTO=productMapper.productToProductDTO(saveProduct);
        return  productRespenseDTO;
    }

    @Override
    public ProductRespenseDTO getProduct(String id) {

        Product product= productRepository.findById(id).get();
        ProductRespenseDTO productRespenseDTO=productMapper.productToProductDTO(product);
        return productRespenseDTO;
    }

    @Override
    public ProductRespenseDTO update(ProductRequestDTO productRequestDTO) {
        Product product=productMapper.ProductDTOToProduct(productRequestDTO);
        Product updatedProduct= productRepository.save(product);
        return productMapper.productToProductDTO(updatedProduct);
    }

    @Override
    public List<ProductRespenseDTO> getAllProducts() {

        List<Product> productList=productRepository.findAll();
        List<ProductRespenseDTO> productRespenseDTOList=productList.stream()
                .map(prod -> productMapper.productToProductDTO(prod))
                .collect(Collectors.toList());
        return productRespenseDTOList;
    }
}
