package com.library.libraryv2.controller;

import com.library.libraryv2.model.Author;
import com.library.libraryv2.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    final
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> listAuthors(){
        return authorService.searchAuthors();
    }

    @GetMapping("/authors/{id}")
    public Author listAuthor(@PathVariable Long id){
        return authorService.searchAuthor(id);
    }

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author){

        return authorService.createAuthor(author);
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@PathVariable Long id,@RequestBody Author author){
        authorService.searchAuthor(id);

        author.setFirstName(author.getFirstName());
        author.setLastName(author.getLastName());

        authorService.createAuthor(author);

        return author;
    }

    @DeleteMapping("/authors/{id}")
    void deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }
}
