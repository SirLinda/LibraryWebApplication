package com.application.library.controller;

import com.application.library.entity.Author;
import com.application.library.service.AuthorService;
import com.application.library.service.CategoryService;
import com.application.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    public CategoryService categoryService;
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/authors")
    public String findAllAuthors(Model model){
        model.addAttribute("authors", authorService.findAllAuthors());
        return "authors";
    }

    @GetMapping("/remove-author/{id}")
    public String deleteauthor(@PathVariable Long id, Model model){
        authorService.deleteAuthor(id);
        model.addAttribute("authors", authorService.findAllAuthors());
        return "authors";
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id, Model model){
        model.addAttribute("author", authorService.findAuthorById(id));
        return "update-author";
    }
    @PostMapping("/update-author/{id}")
    public String saveUpdateAuthor(@PathVariable Long id, Author author, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "update-author";
        }
        authorService.updateAuthor(author);

        model.addAttribute("authors", authorService.findAllAuthors());
        return "redirect:/authors";
    }
    @GetMapping("/add-author")
    public String addAuthor(Author author){
        return "add-author";
    }
    @PostMapping("/save-author")
    public String saveAuthor(Author author, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add-author";
        }
        authorService.createAuthor(author);
        model.addAttribute("author", authorService.findAllAuthors());
        return "redirect:/authors";
    }

}
