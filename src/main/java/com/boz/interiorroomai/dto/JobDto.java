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
public class JobDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long jobId;
    private UserEntity user;
    private PlanEntity plan;
    private String style;
    private String status;
    private LocalDateTime createdAt;
    private Integer creditUsed;
}
