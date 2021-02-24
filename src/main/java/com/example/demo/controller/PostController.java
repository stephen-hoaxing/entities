package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.CategoryService;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping(value = "/")
    public Post createPost(@RequestBody Post post) {
        postService.savePost(post);
        return post;
    }

//    @PutMapping(value = "/{id}")
//    public Post updatePost(@RequestBody Post post) {
//
//    }

}
