package com.boz.interiorroomai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// SUBSCRIPTION
@Entity
@Table(name = "subscription")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;

    @ManyToOne @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne @JoinColumn(name = "plan_id")
    private PlanEntity plan;

    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // ACTIVE, CANCELED, EXPIRED
    private Boolean autoRenew;
}
