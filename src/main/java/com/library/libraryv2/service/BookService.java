package com.library.libraryv2.service;

import com.library.libraryv2.dao.BookDao;
import com.library.libraryv2.model.Book;
import com.library.libraryv2.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService implements BookDao {

    final
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public Book searchBook(Long id) {
        return bookRepository.findById(id).get();

    }

    @Override
    @Transactional
    public List<Book> searchBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Book updateBook(Long id) {

        Book book = bookRepository.findById(id).get();

        book.setBookName(book.getBookName());
        book.setYear(book.getYear());
        book.setPrice(book.getPrice());

        return book;
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    @Transactional
    public List<Book> findByBookName(String bookName) {
        return bookRepository.findAllByBookName(bookName);
    }
}