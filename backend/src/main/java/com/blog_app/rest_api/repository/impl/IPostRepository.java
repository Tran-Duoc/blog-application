package com.blog_app.rest_api.repository.impl;

import com.blog_app.rest_api.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<PostEntity, Long> {
}
