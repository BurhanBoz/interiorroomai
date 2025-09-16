package com.boz.interiorroomai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// PLAN
@Entity
@Table(name = "plan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @Column(nullable = false)
    private String name;

    private String description;
    private BigDecimal price;

    @Column(nullable = false)
    private String planType; // CREDIT, SUBSCRIPTION

    private Integer credits;

    @Lob
    private String features; // JSON string
}
