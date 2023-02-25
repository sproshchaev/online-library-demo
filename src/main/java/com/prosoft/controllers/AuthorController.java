package com.prosoft.controllers;

import com.prosoft.entities.Author;
import com.prosoft.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String booksPage(Model model) {
        List<Author> authorList = authorService.getAllAuthors();
        model.addAttribute("authors", authorList);
        return "authors";
    }
}
