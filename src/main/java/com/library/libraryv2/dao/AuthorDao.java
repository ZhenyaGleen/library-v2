package com.library.libraryv2.dao;


import com.library.libraryv2.model.Author;

import java.util.List;

public interface AuthorDao {

    Author searchAuthor(Long id);

    List<Author> searchAuthors();

    Author createAuthor(Author author);

    Author updateAuthor(Long id);

    void deleteAuthor(Long id);


}