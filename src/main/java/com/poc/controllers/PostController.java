package com.poc.controllers;

import com.poc.repository.PostRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PostController {

    private PostRepository repository;


    @RequestMapping("/")
    public String index() {

        return "Greetings from Spring Boot@@@@@"+ repository.getPosts();
    }

}
