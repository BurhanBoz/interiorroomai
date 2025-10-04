package com.boz.interiorroomai.dto;

import com.boz.interiorroomai.entity.PlanEntity;
import com.boz.interiorroomai.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreditDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long userCreditId;
    private UserDto user;
    private PlanDto plan;
    private Integer totalCredits;
    private Integer remainingCredits;
    private LocalDateTime purchaseDate;
}
