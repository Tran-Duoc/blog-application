package com.blog_app.rest_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "saved_posts")
public class SavedPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Quan hệ với bài viết
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;

    // Quan hệ với người dùng
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
