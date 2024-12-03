package com.blog_app.rest_api.services.impl;

import com.blog_app.rest_api.exception.ResourceNotFoundException;
import com.blog_app.rest_api.entity.PostEntity;
import com.blog_app.rest_api.repository.impl.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService  implements IPostService{

    @Autowired
    IPostRepository repository;

    @Override
    public Page<PostEntity> getAllPosts(Pageable pageable) {
        Page<PostEntity> posts = repository.findAll(pageable);
        return  repository.findAll(pageable);
    }

    @Override
    public PostEntity getPostById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No such post"));
    }


    @Override
    public String getPostsByAuthor(Long id) {
        return "";
    }

    @Override
    public String getPostsByCategory(Long categoryId) {
        return "";
    }

    @Override
    public String createPost(PostEntity post) {
        return "";
    }

    @Override
    public String updatePost(Long postId, PostEntity post) {
        return "";
    }

    @Override
    public String deletePost(Long postId) {
        return "";
    }
}
