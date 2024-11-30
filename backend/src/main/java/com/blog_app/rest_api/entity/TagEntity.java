package com.blog_app.rest_api.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tags")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String slug;

    @ManyToMany(mappedBy = "tags")
    private List<PostEntity> posts;
}
