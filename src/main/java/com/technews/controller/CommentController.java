package com.technews.controller;

import com.technews.model.Comment;
import com.technews.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// class-level annotations
@RestController
public class CommentController {
    @Autowired
    CommentRepository repository;

    @GetMapping("/api/comments") // GET ALL COMMENTS
    public List<Comment> getAllComments() {
        return repository.findAll();
    }
    @GetMapping("/api/comments/{id}") // GET COMMENT BY ID
    public Comment getComment(@PathVariable int id) {
        return repository.getById(id);
    }
    @PostMapping("/api/comments") // POST (ADD) NEW COMMENT
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment comment) {
        return repository.save(comment);
    }

    @PutMapping("/api/updateComment") // PUT (UPDATE) EXISTING COMMENT
    public Comment updateComment(@RequestBody Comment comment) {
        return repository.save(comment);
    }

    @DeleteMapping("/api/comments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id) {
        repository.deleteById(id);
    }
}
