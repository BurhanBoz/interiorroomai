package com.boz.interiorroomai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// USER_CREDIT
@Entity
@Table(name = "user_credit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCreditId;

    @ManyToOne @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne @JoinColumn(name = "plan_id")
    private PlanEntity plan;

    private Integer totalCredits;
    private Integer remainingCredits;
    private LocalDateTime purchaseDate;
}
