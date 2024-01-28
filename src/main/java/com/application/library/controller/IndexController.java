package com.application.library.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
}
