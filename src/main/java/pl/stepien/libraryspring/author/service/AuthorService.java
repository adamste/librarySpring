package pl.stepien.libraryspring.author.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.stepien.libraryspring.author.model.Author;
import pl.stepien.libraryspring.author.repository.AuthorRepository;

@Service
public class AuthorService
{
    private final AuthorRepository authorRepository;

    public AuthorService(final AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors()
    {
        return authorRepository.findAll();
    }
}
