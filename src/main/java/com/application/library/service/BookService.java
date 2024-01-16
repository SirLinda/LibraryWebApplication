package com.application.library.service;

import com.application.library.entity.Book;
import com.application.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book findBookById(Long bookId){
        Book book;
        book = bookRepository.findById(bookId)
                .orElseThrow(()->new RuntimeException("Book not found"));
        return book;
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId){
        Book book;
        book = bookRepository.findById(bookId)
                .orElseThrow(() ->new RuntimeException("Book not found"));
        bookRepository.delete(book);
        //bookRepository.deleteById(book.getId());
    }
}
