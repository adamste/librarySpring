package pl.stepien.libraryspring.author.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pl.stepien.libraryspring.author.model.Author;
import pl.stepien.libraryspring.author.repository.AuthorRepository;

@Service
@AllArgsConstructor
public class AuthorService
{
    private final AuthorRepository authorRepository;

    public List<Author> getAuthors()
    {
        return authorRepository.findAll();
    }
}
