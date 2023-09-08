package pl.stepien.libraryspring.author.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pl.stepien.libraryspring.author.model.AuthorRecord;
import pl.stepien.libraryspring.author.repository.AuthorRepository;

@Service
@AllArgsConstructor
public class AuthorService
{
    private final AuthorRepository authorRepository;

    public List<AuthorRecord> getAuthorsRecords()
    {
        return authorRepository.findAll().stream()
                               .map(entity -> new AuthorRecord(entity.getId(), entity.getName(), entity.getSurname(), entity.getCountry()))
                               .collect(Collectors.toList());
    }
}
