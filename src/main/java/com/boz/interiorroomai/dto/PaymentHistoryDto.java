package com.boz.interiorroomai.dto;

import com.boz.interiorroomai.entity.PlanEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentHistoryDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long paymentId;
    private UserDto user;
    private PlanDto plan;

    private BigDecimal amount;
    private String currency;
    private String status; // SUCCESS, FAILED, PENDING
    private String provider; // Stripe, Iyzico
    private String transactionRef;
    private LocalDateTime createdAt;
}
