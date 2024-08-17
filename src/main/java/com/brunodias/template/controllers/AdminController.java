package com.brunodias.template.controllers;

import com.brunodias.template.dtos.requests.posts.CreatePostRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

    @GetMapping
    public String getAdmin(){
        return "admin controller bruno dias";
    }

    @PostMapping("/create/post")
    public String createPost(@RequestBody @Valid CreatePostRequest request){

        return "criando um post para o blog";
    }
}
