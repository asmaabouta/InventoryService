package com.asmaa.inventoryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data @ToString
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
    private int quantity;
}
