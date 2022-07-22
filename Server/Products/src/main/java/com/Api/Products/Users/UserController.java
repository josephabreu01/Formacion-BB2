package com.Api.Products.Users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    List<User> findAll(){return userRepository.findAll();}

    @GetMapping("/user/{id}")
    User findById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow( ()-> new RuntimeException("No aparecio"));
    }




    @GetMapping("/user/name/{name}")
    public User getCurrentUser( @PathVariable String name) {
        return userRepository.findByName(name);
    }
}
