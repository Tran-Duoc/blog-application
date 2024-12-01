package com.blog_app.rest_api.controllers;


import com.blog_app.rest_api.dto.response.ResponseHandler;
import com.blog_app.rest_api.entity.PostEntity;
import com.blog_app.rest_api.services.impl.IPostService;
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
    public ResponseEntity<Object> getAllPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {

        Pageable pageable = PageRequest.of(page, limit, Sort.by("createdAt").descending());
        Page<PostEntity> posts = postService.getAllPosts(pageable);

        return  ResponseHandler.baseResponse(HttpStatus.OK, "Get all posts successfully", posts.getContent());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPostById(@PathVariable Long id) {
        PostEntity post = postService.getPostById(id);
        if (post == null) {
           return  ResponseHandler.errorResponse(HttpStatus.NOT_FOUND, "Could not find post ");
        }

        return  ResponseHandler.baseResponse(HttpStatus.OK, "Get post successfully",post );
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
    public  ResponseEntity<String> createPost(@RequestBody PostEntity post){
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
