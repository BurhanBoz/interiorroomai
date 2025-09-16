package com.boz.interiorroomai.dto;

import com.boz.interiorroomai.entity.JobEntity;
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
public class FeedbackDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long feedbackId;
    private JobEntity job;
    private UserEntity user;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;
}
