package pl.stepien.libraryspring.author.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pl.stepien.libraryspring.author.exceptions.AuthorNotFoundException;
import pl.stepien.libraryspring.author.model.Author;
import pl.stepien.libraryspring.author.model.AuthorDTO;
import pl.stepien.libraryspring.author.repository.AuthorRepository;

@Service
@RequiredArgsConstructor
public class AuthorService
{
    private final AuthorRepository authorRepository;

    public List<AuthorDTO> getAuthorsRecords()
    {
        return authorRepository.findAll().stream()
                               .map(this::mapEntityToDTO)
                               .collect(Collectors.toList());
    }

    public Optional<AuthorDTO> getById(long id)
    {
        return authorRepository.findById(id).map(this::mapEntityToDTO);
    }

    public AuthorDTO createAuthor(AuthorDTO author)
    {
        final Author entity = authorRepository.save(Author.Factory.create(author));
        return mapEntityToDTO(entity);
    }

    public AuthorDTO updateAuthor(AuthorDTO author, Long id)
    {
        final Author authorFromDB = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Won't update since no such user"));

        authorFromDB.setId(author.getId());
        authorFromDB.setName(author.getName());
        authorFromDB.setSurname(author.getSurname());
        authorFromDB.setCountry(author.getCountry());
        authorFromDB.setPesel(author.getPesel());
        authorFromDB.setAlive(author.isAlive());

        final Author entity = authorRepository.save(authorFromDB);
        return mapEntityToDTO(entity);
    }

    public void deleteAuthor(long id)
    {
        if (authorRepository.existsById(id))
        {
            authorRepository.deleteById(id);
        }
        throw new AuthorNotFoundException("Won't delete since no such user");
    }

    public AuthorDTO patchAlive(boolean isAlive, long id)
    {
        final Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Won't update since no such user"));
        author.setAlive(isAlive);
        authorRepository.save(author);
        return mapEntityToDTO(author);
    }

    private AuthorDTO mapEntityToDTO(Author entity) {
        return new AuthorDTO(entity.getId(), entity.getName(), entity.getSurname(),
                entity.getCountry(), entity.getPesel(), entity.isAlive());
    }
}
