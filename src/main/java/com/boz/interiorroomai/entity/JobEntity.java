package com.boz.interiorroomai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// JOB
@Entity
@Table(name = "job")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @ManyToOne @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne @JoinColumn(name = "plan_id")
    private PlanEntity plan;

    private String style;
    private String status;
    private LocalDateTime createdAt;
    private Integer creditUsed;
}
