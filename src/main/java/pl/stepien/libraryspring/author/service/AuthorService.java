package pl.stepien.libraryspring.author.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pl.stepien.libraryspring.author.exceptions.AuthorNotFoundException;
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

    public Optional<AuthorRecord> getById(long id)
    {
        return authorRepository.findById(id).map(
            a -> new AuthorRecord(a.getId(), a.getName(), a.getSurname(), a.getCountry(), a.getPesel(), a.isAlive()));
    }

    public AuthorRecord createAuthor(AuthorRecord author)
    {
        final Author entity = authorRepository.save(Author.Factory.create(author));
        return new AuthorRecord(entity.getId(), entity.getName(), entity.getSurname(), entity.getCountry(), entity.getPesel(),
                                entity.isAlive());
    }

    public AuthorRecord updateAuthor(AuthorRecord author, Long id)
    {
        final Author authorFromDB = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Won't update since no such user"));

        authorFromDB.setId(author.getId());
        authorFromDB.setName(author.getName());
        authorFromDB.setSurname(author.getSurname());
        authorFromDB.setCountry(author.getCountry());
        authorFromDB.setPesel(author.getPesel());
        authorFromDB.setAlive(author.isAlive());

        final Author entity = authorRepository.save(authorFromDB);
        return new AuthorRecord(entity.getId(), entity.getName(), entity.getSurname(), entity.getCountry(), entity.getPesel(),
                                entity.isAlive());
    }

    public void deleteAuthor(long id)
    {
        final boolean exists = authorRepository.existsById(id);
        if (exists)
        {
            authorRepository.deleteById(id);
        }
        throw new AuthorNotFoundException("Won't delete since no such user");
    }

    public AuthorRecord patchAlive(boolean isAlive, long id)
    {
        final Optional<Author> entity = authorRepository.findById(id);
        if (entity.isPresent())
        {
            final Author author = entity.get();
            author.setAlive(isAlive);
            authorRepository.save(author);
            return new AuthorRecord(author.getId(), author.getName(), author.getSurname(),
                                    author.getCountry(), author.getPesel(), author.isAlive());
        }
        else
        {
            throw new AuthorNotFoundException("Won't patch since no such user");
        }
    }
}
