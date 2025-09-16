package com.boz.interiorroomai.dto;

import com.boz.interiorroomai.entity.PlanEntity;
import com.boz.interiorroomai.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long subscriptionId;
    private UserEntity user;
    private PlanEntity plan;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // ACTIVE, CANCELED, EXPIRED
    private Boolean autoRenew;
}
