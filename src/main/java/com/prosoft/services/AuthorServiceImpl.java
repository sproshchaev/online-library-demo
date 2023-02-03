package com.prosoft.services;

import com.prosoft.entities.Author;
import com.prosoft.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
}
