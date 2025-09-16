package com.boz.interiorroomai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long planId;
    private String name;
    private String description;
    private BigDecimal price;
    private String planType; // CREDIT, SUBSCRIPTION
    private Integer credits;
    private String features; // JSON string
}
