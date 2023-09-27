package pl.stepien.libraryspring.author.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.stepien.libraryspring.author.model.Author;
import pl.stepien.libraryspring.author.model.AuthorDTO;
import pl.stepien.libraryspring.author.repository.AuthorRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        final Author author = new Author(1L, "name", "surname", "country", 999999999L, false);
        Mockito.when(authorRepository.findAll()).thenReturn(List.of(author));
        //when
        final List<AuthorDTO> result = authorService.getAuthorsRecords();
        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getId()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("name");
        assertThat(result.get(0).getSurname()).isEqualTo("surname");
        assertThat(result.get(0).getCountry()).isEqualTo("country");
        assertThat(result.get(0).getPesel()).isEqualTo(999999999L);
        assertThat(result.get(0).isAlive()).isFalse();
    }
}