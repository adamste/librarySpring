package pl.stepien.libraryspring.author.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import pl.stepien.libraryspring.author.model.AuthorRecord;
import pl.stepien.libraryspring.author.service.AuthorService;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AuthorService authorService;

    public static final String DUMMY_JSON = "{" +
            "  \"id\": 0," +
            "  \"name\": \"name\"," +
            "  \"surname\": \"surname\"," +
            "  \"country\": \"country\"," +
            "  \"pesel\": 0," +
            "  \"alive\": false" +
            "}";

    @Test
    public void givenOneAuthor_thenReturnIt_getAllAuthors() throws Exception
    {
        //given
        final AuthorRecord author = new AuthorRecord(1L, "name", "surname", "country", 94020600570L, false);
        given(this.authorService.getAuthorsRecords()).willReturn(List.of(author));

        //when
        final MockHttpServletRequestBuilder result = get("/authors");

        //then
        this.mvc.perform(result)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.authorRecordList[:1].id").value(1))
                .andExpect(jsonPath("$._embedded.authorRecordList[:1].name").value("name"))
                .andExpect(jsonPath("$._embedded.authorRecordList[:1].surname").value("surname"))
                .andExpect(jsonPath("$._embedded.authorRecordList[:1].country").value("country"))
                .andExpect(jsonPath("$._embedded.authorRecordList[:1].pesel").value(94020600570L))
                .andExpect(jsonPath("$._embedded.authorRecordList[:1].alive").value(false))
                .andExpect(jsonPath("$._embedded.authorRecordList[:1].alive").value(false))
                .andExpect(jsonPath("$._links./authors.href").value("http://localhost/authors"));
    }

    @Test
    public void givenExistingAuthor_thenAuthorRetrieved_getAuthorById() throws Exception {
        //given
        final AuthorRecord author = new AuthorRecord(1L, "name", "surname", "country", 94020600570L, false);
        given(this.authorService.getById(1L)).willReturn(Optional.of(author));

        //when
        final MockHttpServletRequestBuilder result = get("/authors/" + 1L);

        //then
        this.mvc.perform(result)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.surname").value("surname"))
                .andExpect(jsonPath("$.country").value("country"))
                .andExpect(jsonPath("$.pesel").value(94020600570L))
                .andExpect(jsonPath("$.alive").value(false))
                .andExpect(jsonPath("$._links.self.href").value("http://localhost/authors/1"))
                .andExpect(jsonPath("$._links./authors.href").value("http://localhost/authors"));
    }

    @Test
    public void givenNonExistingAuthor_then404_getAuthorById() throws Exception {
        //given
        given(this.authorService.getById(1L)).willReturn(Optional.empty());
        //when
        ResultActions actions = this.mvc.perform(get("/authors/" + 1L));
        //then
        actions.andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteAuthor_deleteAuthorById() throws Exception {
        ResultActions actions = this.mvc.perform(delete("/authors/" + 1L));
        actions.andExpect(status().isOk());
    }

    @Test
    public void createAuthor_thenReturnAuthorLinkToIt_postNewAuthor() throws Exception {
        //given
        final AuthorRecord author = new AuthorRecord(1L, "name", "surname", "country", 94020600570L, false);
        given(this.authorService.createAuthor(any())).willReturn(author);

        //when
        ResultActions action = this.mvc.perform(post("/authors")
                .contentType(MediaType.APPLICATION_JSON).content(DUMMY_JSON));
        //then
        action.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.surname").value("surname"))
                .andExpect(jsonPath("$.country").value("country"))
                .andExpect(jsonPath("$.pesel").value(94020600570L))
                .andExpect(jsonPath("$.alive").value(false))
                .andExpect(jsonPath("$._links.self.href").value("http://localhost/authors/1"))
                .andExpect(jsonPath("$._links./authors.href").value("http://localhost/authors"));
    }

    @Test
    public void updateAuthor_thenReturnAuthorLinkToIt_putAuthor() throws Exception {
        //given
        final AuthorRecord author = new AuthorRecord(1L, "name", "surname", "country", 94020600570L, false);
        given(this.authorService.updateAuthor(any(), any())).willReturn(author);

        //when
        ResultActions action = this.mvc.perform(put("/authors/1")
                .contentType(MediaType.APPLICATION_JSON).content(DUMMY_JSON));
        //then
        action.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.surname").value("surname"))
                .andExpect(jsonPath("$.country").value("country"))
                .andExpect(jsonPath("$.pesel").value(94020600570L))
                .andExpect(jsonPath("$.alive").value(false))
                .andExpect(jsonPath("$._links.self.href").value("http://localhost/authors/1"))
                .andExpect(jsonPath("$._links./authors.href").value("http://localhost/authors"));
    }

    @Test
    public void patchAuthor_thenReturnAuthorLinkToIt_patchAuthor() throws Exception {
        //given
        final AuthorRecord author = new AuthorRecord(1L, "name", "surname", "country", 94020600570L, false);
        given(this.authorService.patchAlive(false, 1L)).willReturn(author);

        //when
        ResultActions action = this.mvc.perform(patch("/authors/1/alive/false")
                .contentType(MediaType.APPLICATION_JSON).content(DUMMY_JSON));
        //then
        action.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.surname").value("surname"))
                .andExpect(jsonPath("$.country").value("country"))
                .andExpect(jsonPath("$.pesel").value(94020600570L))
                .andExpect(jsonPath("$.alive").value(false))
                .andExpect(jsonPath("$._links.self.href").value("http://localhost/authors/1"))
                .andExpect(jsonPath("$._links./authors.href").value("http://localhost/authors"));
    }
}