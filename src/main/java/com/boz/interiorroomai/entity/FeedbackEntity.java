package com.boz.interiorroomai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// FEEDBACK
@Entity
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @ManyToOne @JoinColumn(name = "job_id")
    private JobEntity job;

    @ManyToOne @JoinColumn(name = "user_id")
    private UserEntity user;

    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;
}
