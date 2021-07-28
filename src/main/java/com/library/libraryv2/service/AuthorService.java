package com.library.libraryv2.service;

import com.library.libraryv2.dao.AuthorDao;
import com.library.libraryv2.model.Author;
import com.library.libraryv2.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthorService implements AuthorDao {

    Logger LOGGER = LoggerFactory.getLogger(AuthorService.class);

    final
    AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    @Transactional
    public Author searchAuthor(Long id) {
        LOGGER.info("You got author from id: " + id);
        return authorRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Author> searchAuthors() {
        LOGGER.info("You got authors");
        return authorRepository.findAll();
    }

    @Override
    @Transactional
    public Author createAuthor(Author author) {
        LOGGER.info("You created author");
        return authorRepository.save(author);
    }

    @Override
    @Transactional
    public Author updateAuthor(Long id) {

        Author author = authorRepository.findById(id).get();

        author.setFirstName(author.getFirstName());
        author.setLastName(author.getLastName());
        LOGGER.info("You updated author");

        authorRepository.save(author);
        return author;
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        LOGGER.info("You deleted author: " + id);

        authorRepository.deleteById(id);

    }
}