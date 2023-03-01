package com.technews.controller;

import com.technews.model.Post;
import com.technews.model.User;
import com.technews.repository.UserRepository;
import com.technews.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// class-level annotations
@RestController
public class UserController {
    // instance-level annotations
    @Autowired // tells Spring to scan the project for objects that we need to be instantiated for a class or method to run
            UserRepository repository; // connecting to folder repository.UserRepository
    @Autowired // ...it also keeps the program "light"
    VoteRepository voteRepository; // connecting to folder repository.VoteRepository

    @GetMapping("/api/users") // GET ALL USERS
    public List<User> getAllUsers() { // GET METHOD... without 'void' MUST have a return type
        List<User> userList = repository.findAll(); // return a list of users
        for (User u : userList) { // for every User; assigned to variable u inside userList
            List<Post> postList = u.getPosts();
            for (Post p : postList) {
                p.setVoteCount(voteRepository.countVotesByPostId(p.getId()));
            }
        }
        return userList;
    }

    @GetMapping("/api/users/{id}") // GET USER BY ID
    public User getUserById(@PathVariable Integer id) { // GET METHOD & method-level annotation
        User returnUser = repository.getById(id); // deprecated?
        List<Post> postList = returnUser.getPosts();
        for (Post p: postList) {
            p.setVoteCount(voteRepository.countVotesByPostId(p.getId()));
        }
        return returnUser;
    }

    @PostMapping("/api/users") // POST (ADD) NEW USER
    public User addUser(@RequestBody User user) { // POST METHOD & method-level annotation
        // Encrypt password
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        repository.save(user);
        return user;
    }

    @PutMapping("/api/users/{id}") // PUT (MODIFY) EXISTING USER
    public User updateUser(@PathVariable int id, @RequestBody User user) { // PUT METHOD & method-level annotation
        User tempUser = repository.getById(id); // deprecated?

        if (!tempUser.equals(null)) { // always true
            user.setId(tempUser.getId());
            repository.save(user);
        }
        return user;
    }

    @DeleteMapping("/api/users/{id}") // DELETE EXISTING USER BY ID
    @ResponseStatus(HttpStatus.NO_CONTENT) // HTTP STATUS CODE
    public void deleteUser(@PathVariable int id) { // method-level annotation
        repository.deleteById(id);
    }
}