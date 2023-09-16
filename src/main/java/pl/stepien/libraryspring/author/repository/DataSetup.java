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
            new Author(null, "Jarosław", "Krygier", "Poland", 80112586191L, true),
            new Author(null, "Piotr", "Kaniewski", "Poland", 49032045991L, false),
            new Author(null, "Jerzy", "Osiowski", "Poland", 64120567892L, true),
            new Author(null, "Jerzy", "Szabatin", "Poland", 59091588744L, false),
            new Author(null, "Robert", "Resnick", "USA", 84011872818L, true),
            new Author(null, "David", "Halliday", "USA", 86122497696L, false),
            new Author(null, "Joseph", "Gay-Lussac", "France", 68111421336L, false)
        );
        authorRepository.saveAll(authors);
    }
}
