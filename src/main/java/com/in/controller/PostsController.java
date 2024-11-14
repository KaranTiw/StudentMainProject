package com.in.controller;

import com.in.entity.Posts;
import com.in.repository.CommentRepository;
import com.in.repository.PostsRepository;
import jakarta.transaction.UserTransaction;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {

    private PostsRepository postsRepository;

    private CommentRepository commentRepository;


    public PostsController(PostsRepository postsRepository, CommentRepository commentRepository) {
        this.postsRepository = postsRepository;
        this.commentRepository = commentRepository;
    }


    @PostMapping
    public String insertDetails(
            @RequestBody Posts posts
    ) {
        postsRepository.save(posts);

        return "Post details inserted successfully";


    }



    @DeleteMapping
    public String deleteDetails(@RequestParam Long postsId) {
        postsRepository.deleteById(postsId);

        return "Post details deleted successfully";
    }

//
//    @PutMapping
//    public String updateDetails(@RequestBody Posts posts,@RequestParam Long postsId){
//        postsId = posts.();
//        postsRepository.save(posts);
//
//    }


    @GetMapping("/add")
    public Iterable<Posts> getAllPosts() {
        return postsRepository.findAll();
    }



    @GetMapping("/post/{id}")
    public Posts getPostById(@PathVariable("id") Long postsId) {
        return postsRepository.findById(postsId).orElse(null);
    }










}


