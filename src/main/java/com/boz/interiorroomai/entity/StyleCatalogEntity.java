package com.boz.interiorroomai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "style_catalog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StyleCatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long styleId;

    private String name;
    private String description;
    private Boolean active = true;
}
