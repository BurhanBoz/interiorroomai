package com.boz.interiorroomai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// JOB_OUTPUT
@Entity
@Table(name = "job_output")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOutputEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outputId;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobEntity job;

    private String imageUrl;
    private String qualityType; // SD, ControlNet, ESRGAN
    private LocalDateTime createdAt;
}