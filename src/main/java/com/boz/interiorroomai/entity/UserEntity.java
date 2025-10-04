package com.boz.interiorroomai.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// USER
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true, name = "user_name")
    private String userName;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false)
    private String role = "USER";

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
