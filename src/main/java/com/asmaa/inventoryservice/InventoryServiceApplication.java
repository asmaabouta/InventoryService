package com.asmaa.inventoryservice;

import com.asmaa.inventoryservice.entities.Product;
import com.asmaa.inventoryservice.repositories.ProductRepository;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(new Product(null,"Computer Desktop HP",5000.00));
            productRepository.save(new Product(null,"Computer Desktop HP",7000.50));
            productRepository.findAll().forEach(System.out::println);

        };
    }
}
