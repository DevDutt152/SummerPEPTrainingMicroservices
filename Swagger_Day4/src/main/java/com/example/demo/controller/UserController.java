package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository repo;

    // GET ALL USERS
    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return repo.findAll();
    }

    // GET USER BY ID
    @GetMapping("/user/{id}")
    public Optional<UserEntity> getUserById(@PathVariable int id) {
        return repo.findById(id);
    }

    // CREATE USER
    @PostMapping("/user")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return repo.save(user);
    }

    // UPDATE USER
    @PutMapping("/user/{id}")
    public UserEntity updateUser(@PathVariable int id,
                                 @RequestBody UserEntity updatedUser) {

        UserEntity user = repo.findById(id).orElse(null);

        if (user != null) {
            user.setName(updatedUser.getName());
            return repo.save(user);
        }

        return null;
    }

    // DELETE USER
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {

        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "User with ID " + id + " deleted successfully";
        }

        return "User not found";
    }
}