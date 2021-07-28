package com.library.libraryv2.service;

import com.library.libraryv2.dao.AuthorDao;
import com.library.libraryv2.model.Author;
import com.library.libraryv2.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService implements AuthorDao {

    final
    AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    @Transactional
    public Author searchAuthor(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<Author> searchAuthors() {
        return authorRepository.findAll();
    }

    @Override
    @Transactional
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    @Transactional
    public Author updateAuthor(Long id) {

        Author author = authorRepository.findById(id).get();

        author.setFirstName(author.getFirstName());
        author.setLastName(author.getLastName());

        authorRepository.save(author);
        return author;
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {

        authorRepository.deleteById(id);

    }
}