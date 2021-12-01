package com.asmaa.inventoryservice;

import com.asmaa.inventoryservice.entities.Product;
import com.asmaa.inventoryservice.repositories.ProductRepository;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            productRepository.save(new Product("DX21QDHI32JH","Computer Desktop HP",5000.00, 22));
            productRepository.save(new Product("BJ65QDHI37DG","Printer",7000.50, 12));
            productRepository.save(new Product("OGHSM56GS8HD","MacBook",10000.50, 43));
            productRepository.findAll().forEach(System.out::println);

            restConfiguration.exposeIdsFor(Product.class);
        };
    }
}
