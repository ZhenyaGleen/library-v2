package com.library.libraryv2.controller;

import com.library.libraryv2.model.Author;
import com.library.libraryv2.model.Book;
import com.library.libraryv2.service.AuthorService;
import com.library.libraryv2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    final
    AuthorService authorService;

    final
    BookService bookService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/books")
    public List<Book> listBook(){
        return bookService.searchBooks();
    }

    @GetMapping("/books/{id}")
    public Book listBook(@PathVariable Long id){
        return bookService.searchBook(id);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book, @RequestBody Author author){
        return bookService.createBook(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book){
        bookService.searchBook(id);

        book.setBookName(book.getBookName());
        book.setYear(book.getYear());
        book.setPrice(book.getPrice());

        bookService.createBook(book);

        return book;
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}