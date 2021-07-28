package com.library.libraryv2.service;

import com.library.libraryv2.dao.BookDao;
import com.library.libraryv2.model.Book;
import com.library.libraryv2.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService implements BookDao {

    Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    final
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public Book searchBook(Long id) {
        LOGGER.info("You got the book from id: " + id);
        return bookRepository.findById(id).get();

    }

    @Override
    @Transactional
    public List<Book> searchBooks() {
        LOGGER.info("You got books");
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Book createBook(Book book) {
        LOGGER.info("You created book");
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Book updateBook(Long id) {

        Book book = bookRepository.findById(id).get();

        book.setBookName(book.getBookName());
        book.setYear(book.getYear());
        book.setPrice(book.getPrice());
        LOGGER.info("You updated book");

        return book;
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        LOGGER.info("You deleted the book from id: " + id);
        bookRepository.deleteById(id);

    }

    @Override
    @Transactional
    public List<Book> findByBookName(String bookName) {
        LOGGER.info("You found the book: " + bookName);
        return bookRepository.findAllByBookName(bookName);
    }
}