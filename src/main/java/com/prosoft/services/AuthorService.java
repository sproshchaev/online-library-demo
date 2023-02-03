package com.prosoft.services;

import com.prosoft.entities.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(long id);

    void updateAuthor(Author author);

    void deleteAuthor(Author author);

    Author createAuthor(Author author);

}
