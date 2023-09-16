package pl.stepien.libraryspring.author.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import pl.stepien.libraryspring.author.model.Author;
import pl.stepien.libraryspring.author.service.AuthorService;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest
{
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AuthorService authorService;

    @Test
    public void givenExistingAuthor_thenAuthorRetrieved() throws Exception
    {
        final Author author = new Author(1L, "name", "surname", "country", 94020600570L, false);
        given(this.authorService.getById(1L)).willReturn(Optional.of(author));

        this.mvc.perform(get("/authors/" + 1L)).andExpect(status().isOk());
    }

    @Test
    public void givenNonExistingAuthor_then404() throws Exception
    {
        given(this.authorService.getById(1L)).willReturn(Optional.empty());
        this.mvc.perform(get("/authors/" + 1L)).andExpect(status().is4xxClientError());
    }
}