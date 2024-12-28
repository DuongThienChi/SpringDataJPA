package com.example.SpringDataJPA.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;
@Entity
@Table(name = "java_product_001")
public class ProductEntity {
    @Id
    private Long id;
    private String productName;
    private Double productPrice;
}
