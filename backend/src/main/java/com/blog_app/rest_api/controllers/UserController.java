package com.blog_app.rest_api.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.version.prefix}/user")
public class UserController {

    @GetMapping("/all")
    public String getUser(){
            return "hello world";
    }

}

