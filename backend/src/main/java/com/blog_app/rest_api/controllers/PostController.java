package com.blog_app.rest_api.controllers;


import com.blog_app.rest_api.dto.request.PostRequestDTO;
import com.blog_app.rest_api.dto.response.ResponseData;
import com.blog_app.rest_api.dto.response.ResponseError;
import com.blog_app.rest_api.entity.PostEntity;
import com.blog_app.rest_api.services.impl.IPostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.version.prefix}/post")
public class PostController {
    @Autowired
    IPostService postService;
    @GetMapping("/all")
    public ResponseData<List<PostEntity>> getAllPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        try {
            Pageable pageable = PageRequest.of(page, limit, Sort.by("createdAt").descending());
            Page<PostEntity> posts = postService.getAllPosts(pageable);
            return new ResponseData<>(HttpStatus.OK.value(), "get posts successfully", posts.getContent());
        } catch (Exception e){
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "get posts successfully");
        }
    }

    @GetMapping("/{id}")
    public ResponseData<PostEntity> getPostById(@Valid @PathVariable Long id) {
        try {
            PostEntity post = postService.getPostById(id);
            return   new ResponseData<>(HttpStatus.OK.value(), "Get post successfully",post );

        } catch (Exception e){
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Could not get post");

        }
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<String> getPostsByAuthor(@PathVariable Long id) {
        return ResponseEntity.ok("author {id}");
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<String> getPostsByCategory(@PathVariable Long categoryId) {

        return ResponseEntity.ok("/category/{categoryId}");
    }


    @PostMapping("/new-post")
    public  ResponseEntity<String> createPost(@Valid @RequestBody PostRequestDTO post){
        System.out.println(post);
        return ResponseEntity.ok("created post");
    }

    @PutMapping("/update-post/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id,@RequestBody PostEntity updatePost){
        return ResponseEntity.ok("updated post");
    }

    @DeleteMapping("/delete-post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        return ResponseEntity.ok("deleted post");
    }



}
