package com.blog_app.rest_api.entity;


import com.blog_app.rest_api.enums.users.UserRole;
import com.blog_app.rest_api.enums.users.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String avatar;

    @Column(columnDefinition = "TEXT")
    private String bio;

    private LocalDateTime createdAt;

    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    private UserStatus status;


    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<PostEntity> posts;
}
