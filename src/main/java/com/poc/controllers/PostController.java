package com.poc.controllers;

import com.poc.repository.PostRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class PostController {

    @Autowired
    private PostRepository repository;

    @RequestMapping("/")
    public String index() {
        return "There are totally "+ repository.getPosts().size() + " posts";
    }

}
