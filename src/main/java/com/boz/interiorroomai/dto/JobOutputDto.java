package com.boz.interiorroomai.dto;

import com.boz.interiorroomai.entity.JobEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOutputDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long outputId;
    private JobEntity job;
    private String imageUrl;
    private String qualityType; // SD, ControlNet, ESRGAN
    private LocalDateTime createdAt;
}
