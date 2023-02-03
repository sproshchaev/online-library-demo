package com.prosoft.shell;

import com.prosoft.entities.Author;
import com.prosoft.services.AuthorService;
import org.h2.tools.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.sql.SQLException;

@ShellComponent
public class AppEventsCommands {

    private final AuthorService authorService;

    @Autowired
    public AppEventsCommands(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Метод startConsoleH2 запускает консоль
     */
    @ShellMethod(value = "Start console H2", key = {"c", "console"})
    public void startConsoleH2() {
        try {
            Console.main();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @ShellMethod(value = "Create a new Author of books in the library", key = {"ca", "createauthor"})
    public String createNewAuthor(@ShellOption(defaultValue = "Stephen Edwin King") String fullName) {
        return authorService.createAuthor(new Author(fullName)).toString();
    }

    @ShellMethod(value = "Get All Authors", key = {"gaa", "getallauthors"})
    public void getAllAuthors() {
        System.out.println(authorService.getAllAuthors().toString());
    }

    @ShellMethod(value = "Get Author By id", key = {"gabi", "getauthorbyid"})
    public void getAuthorById(@ShellOption(defaultValue = "1") long id) {
        System.out.println(authorService.getAuthorById(id).toString());
    }

    @ShellMethod(value = "Updating information about the author", key = {"ua", "updateauthor"})
    public void updateAuthor(
            @ShellOption(defaultValue = "1") long id,
            @ShellOption(defaultValue = "Gianni Rodari") String fullName) {
        authorService.updateAuthor(new Author(id, fullName));
    }

    @ShellMethod(value = "Deleting author data from the library", key = {"da", "deleteauthor"})
    public void deleteAuthor(
            @ShellOption(defaultValue = "1") long id,
            @ShellOption(defaultValue = "Gianni Rodari") String fullName) {
        authorService.deleteAuthor(new Author(id, fullName));
    }

}
