package com.boz.interiorroomai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String email;
    private String passwordHash;
    private String role = "USER";
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
