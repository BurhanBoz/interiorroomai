package com.boz.interiorroomai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StyleCatalogDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long styleId;

    private String name;
    private String description;
    private Boolean active = true;
}
