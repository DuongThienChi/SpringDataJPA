package com.example.SpringDataJPA.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "java_order_001")
public class OrderEntity {
    @Id
    private Long id;
}
