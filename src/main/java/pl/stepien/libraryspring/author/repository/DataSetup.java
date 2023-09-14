package pl.stepien.libraryspring.author.repository;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.stepien.libraryspring.author.model.Author;

@Component
@Profile("init")
@RequiredArgsConstructor
public class DataSetup implements CommandLineRunner
{
    private final AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception
    {
        final List<Author> authors = List.of(
            new Author("Jarosław", "Krygier", "Poland"),
            new Author("Piotr", "Kaniewski", "Poland"),
            new Author("Jerzy", "Osiowski", "Poland"),
            new Author("Jerzy", "Szabatin", "Poland"),
            new Author("Jerzy", "Szabatin", "Poland"),
            new Author("Robert", "Resnick", "USA"),
            new Author("David", "Halliday", "USA"),
            new Author("Joseph", "Gay-Lussac", "France")
        );
        authorRepository.saveAll(authors);
    }
}
