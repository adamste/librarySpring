package pl.stepien.libraryspring.author.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.stepien.libraryspring.author.model.Author;
import pl.stepien.libraryspring.author.model.AuthorRecord;
import pl.stepien.libraryspring.author.repository.AuthorRepository;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest
{
    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Test
    void getAuthorRecordsWhenCorrectData()
    {
        //given
        Mockito.when(authorRepository.findAll()).thenReturn(List.of(new Author(1L, "name", "surname", "country")));
        //when
        final List<AuthorRecord> result = authorService.getAuthorsRecords();
        //then
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).id());
        assertEquals("name", result.get(0).name());
        assertEquals("surname", result.get(0).surname());
        assertEquals("country", result.get(0).country());
    }
}