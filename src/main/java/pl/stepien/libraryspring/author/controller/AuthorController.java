package pl.stepien.libraryspring.author.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.stepien.libraryspring.author.model.Author;
import pl.stepien.libraryspring.author.service.AuthorService;

@RestController
public class AuthorController
{
    private final AuthorService authorService;

    public AuthorController(final AuthorService authorService)
    {
        this.authorService = authorService;
    }

    @GetMapping("/allAuthors")
    public List<Author> showAllAuthors()
    {
        return authorService.getAuthors();
    }
}