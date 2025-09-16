package com.boz.interiorroomai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
