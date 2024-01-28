package com.application.library.service;

import com.application.library.entity.Author;
import com.application.library.entity.Publisher;
import com.application.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long authorId){
        Author author;
        author = authorRepository.findById(authorId)
                .orElseThrow(()->new RuntimeException("Author not found"));
        return author;
    }

    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public void updateAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthor(Long authorId){
        Author author;
        author = authorRepository.findById(authorId)
                .orElseThrow(()->new RuntimeException("Author not found"));
        authorRepository.delete(author);
        //authorRepository.deleteById(authorId);
    }
}
