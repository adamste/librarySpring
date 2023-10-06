package pl.stepien.libraryspring.author.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.stepien.libraryspring.author.exceptions.AuthorNotFoundException;
import pl.stepien.libraryspring.author.model.Author;
import pl.stepien.libraryspring.author.model.AuthorDTO;
import pl.stepien.libraryspring.author.repository.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService
{
    private final AuthorRepository authorRepository;

    public List<AuthorDTO> getAuthorsRecords()
    {
        return authorRepository.findAll().stream()
                .map(AuthorMapper::mapEntityToDTO)
                               .collect(Collectors.toList());
    }

    public AuthorDTO getById(long id) {
        return authorRepository.findById(id)
                .map(AuthorMapper::mapEntityToDTO)
                .orElseThrow(() -> AuthorNotFoundException.NO_ID);
    }

    public AuthorDTO createAuthor(AuthorDTO author)
    {
        return AuthorMapper.mapEntityToDTO(authorRepository.save(Author.Factory.create(author)));
    }

    public AuthorDTO updateAuthor(AuthorDTO author, Long id)
    {
        Author authorFromDB = authorRepository.findById(id).orElseThrow(() -> AuthorNotFoundException.NO_UPDATE);

        authorFromDB.setId(author.getId());
        authorFromDB.setName(author.getName());
        authorFromDB.setSurname(author.getSurname());
        authorFromDB.setCountry(author.getCountry());
        authorFromDB.setPesel(author.getPesel());
        authorFromDB.setAlive(author.isAlive());

        return AuthorMapper.mapEntityToDTO(authorRepository.save(authorFromDB));
    }

    public void deleteAuthor(long id)
    {
        if (authorRepository.existsById(id))
        {
            authorRepository.deleteById(id);
        }
        throw AuthorNotFoundException.NO_DELETE;
    }

    public AuthorDTO patchAlive(boolean isAlive, long id)
    {
        Author author = authorRepository.findById(id).orElseThrow(() -> AuthorNotFoundException.NO_UPDATE);
        author.setAlive(isAlive);
        authorRepository.save(author);
        return AuthorMapper.mapEntityToDTO(author);
    }
}
