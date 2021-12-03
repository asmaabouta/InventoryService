package com.asmaa.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;


@AllArgsConstructor @NoArgsConstructor @Data @ToString
public class ProductRequestDTO {

    private String id;
    private String name;
    private Double price;
    private int quantity;
}
