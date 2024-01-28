package com.application.library.controller;

import com.application.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String findAllAuthors(Model model){
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "publishers";
    }
}
