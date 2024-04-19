package com.example.sessionmanger.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    private static final String MSG = "Hello ";

    @GetMapping
    public String home(Principal principal, HttpSession session){
        increment(session);
        return MSG + principal.getName();
    }

    @GetMapping(value = "counter")
    public String counter(HttpSession httpSession){
        return "Session: " + httpSession.getAttribute(MSG);
    }

    private void increment(HttpSession session) {
       var counter = session.getAttribute(MSG) == null ? 0 : (Integer) session.getAttribute(MSG);
       session.setAttribute(MSG, counter += 1);
    }
}
