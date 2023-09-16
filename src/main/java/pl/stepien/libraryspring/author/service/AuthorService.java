package pl.stepien.libraryspring.author.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pl.stepien.libraryspring.author.model.Author;
import pl.stepien.libraryspring.author.model.AuthorRecord;
import pl.stepien.libraryspring.author.repository.AuthorRepository;

@Service
@RequiredArgsConstructor
public class AuthorService
{
    private final AuthorRepository authorRepository;

    public List<AuthorRecord> getAuthorsRecords()
    {
        return authorRepository.findAll().stream()
                               .map(entity ->
                                        new AuthorRecord(entity.getId(), entity.getName(), entity.getSurname(),
                                                         entity.getCountry(), entity.getPesel(), entity.isAlive()))
                               .collect(Collectors.toList());
    }

    public Optional<Author> getById(long id)
    {
        return authorRepository.findById(id);
    }

    public Author saveAuthor(AuthorRecord author, Long id)
    {
        return authorRepository.save(new Author(id, author.name(), author.surname(), author.country(), author.pesel(), author.isAlive()));
    }

    public Author updateAuthor(AuthorRecord author, Long id) throws IOException
    {
        if (authorRepository.findById(id).isPresent())
        {
            return authorRepository.save(
                new Author(id, author.name(), author.surname(), author.country(), author.pesel(), author.isAlive()));
        }
        else
        {
            throw new IOException("coudn't find an author with id " + id);
        }
    }

    public void deleteAuthor(long id) throws IOException
    {
        if (authorRepository.findById(id).isPresent())
        {
            authorRepository.deleteById(id);
        }
        else
        {
            throw new IOException("coudn't find an author with id " + id);
        }
    }
}
