package com.blog_app.rest_api.services.impl;

import com.blog_app.rest_api.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IPostService {
    Page<PostEntity> getAllPosts(Pageable pageable);
    PostEntity getPostById(Long Id);
    String getPostsByAuthor(Long id);
    String getPostsByCategory(Long categoryId);
    String createPost(PostEntity post);
    String updatePost(Long postId, PostEntity post);
    String deletePost(Long postId);
}
