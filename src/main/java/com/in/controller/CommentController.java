package com.in.controller;

import com.in.entity.Comment;
import com.in.repository.CommentRepository;
import com.in.repository.PostsRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi1/comments")
public class CommentController {

    private CommentRepository commentRepository;
    private PostsRepository postsRepository;

    public CommentController(CommentRepository commentRepository, PostsRepository postsRepository){
        this.commentRepository = commentRepository;
        this.postsRepository = postsRepository;
    }


    @PostMapping("comment/{id}")
    public String insertComment(
            @RequestBody Comment comment,
            @PathVariable("id") Long postsId
            ){
        comment.setPosts(postsRepository.findById(postsId).orElse(null));
        commentRepository.save(comment);
        return "Comment inserted successfully";

    }


@DeleteMapping("comment/{id}")
    public String deleteComment(@PathVariable("id") Long postsId){
        commentRepository.deleteById(postsId);
        return "Comment deleted successfully";
    }

    @PutMapping("comment/{id}")

    public Comment updateComment(
            @PathVariable("id") Long postsId,
            @RequestBody Comment comment
            ){
        comment.setPosts(postsRepository.findById(postsId).orElse(null));
        commentRepository.save(comment);
        return comment;
    }


    @GetMapping("/add/{id}")
    public Comment getCommentById(@PathVariable("id") Long postsId){
        return commentRepository.findById(postsId).orElse(null);
    }

    @GetMapping("comment/{id}")

    public Iterable<Comment> getAllComments(){
        return commentRepository.findAll();


    }



}
