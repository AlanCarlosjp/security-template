package com.example.multilogin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {


    @GetMapping()
    @PreAuthorize("isAuthenticated()")
    public String secured(){
        return "SECURED";
    }

    @GetMapping(value = "/p")
    @PreAuthorize("permitAll()")
    public String permitAll(){
        return "FREE";
    }

}
