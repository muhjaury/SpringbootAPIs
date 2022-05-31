package com.javaguides.springbootapi.controller;

import com.javaguides.springbootapi.exception.ResourceNotFoundException;
import com.javaguides.springbootapi.model.User;
import com.javaguides.springbootapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //Select All User
    @GetMapping
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    //Create User API
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    //Select User by ID
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not exist with id "+id));
        return ResponseEntity.ok(user);
    }

    //Update User Email by ID
    @PatchMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User userDetails){
        User updateUser = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not exist with id "+id));

        updateUser.setEmail(userDetails.getEmail());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }


    //Delete User by ID
    @DeleteMapping("{id}")
    public  ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not exist with id "+id));

        userRepository.delete(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
