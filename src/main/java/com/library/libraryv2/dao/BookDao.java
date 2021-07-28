package com.library.libraryv2.dao;

import com.library.libraryv2.model.Book;

import java.util.List;

public interface BookDao {

    Book searchBook(Long id);

    List<Book> searchBooks();

    Book createBook(Book book);

    Book updateBook(Long id);

    void deleteBook(Long id);

    List<Book> findByBookName(String bookName);
}