package pl.stepien.libraryspring.author.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.io.IOException;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import pl.stepien.libraryspring.author.model.Author;
import pl.stepien.libraryspring.author.model.AuthorRecord;
import pl.stepien.libraryspring.author.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController
{
    private final AuthorService authorService;

    @GetMapping(value = "/authors")
    public ResponseEntity<CollectionModel<AuthorRecord>> showAllAuthors()
    {
        final List<AuthorRecord> authorsRecords = authorService.getAuthorsRecords();
        return ResponseEntity.status(HttpStatus.OK).body(CollectionModel.of(authorsRecords,
                                                                            linkTo(
                                                                                methodOn(AuthorController.class).showAllAuthors()).withRel(
                                                                                "/authors")));
    }

    @GetMapping(value = "/authors/{id}")
    public ResponseEntity<EntityModel<Author>> showAuthor(@PathVariable("id") long id)
    {
        return authorService.getById(id)
                            .map(author -> ResponseEntity.ok().body(
                                EntityModel.of(author,
                                               linkTo(methodOn(AuthorController.class).showAuthor(id)).withSelfRel(),
                                               linkTo(methodOn(AuthorController.class).showAllAuthors()).withRel("/authors")
                                ))).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @RequestMapping(method = RequestMethod.HEAD, value = "/authors/{id}")
    public ResponseEntity<EntityModel<Author>> isAuthor(@PathVariable("id") long id)
    {
        return authorService.getById(id)
                            .map(author -> ResponseEntity.ok().body(
                                EntityModel.of(author,
                                               linkTo(methodOn(AuthorController.class).showAuthor(id)).withSelfRel(),
                                               linkTo(methodOn(AuthorController.class).showAllAuthors()).withRel("/authors")
                                ))).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/authors")
    public ResponseEntity<EntityModel<Author>> createAuthor(@RequestBody AuthorRecord author)
    {
        final Author entity = authorService.saveAuthor(author, null);
        return ResponseEntity.ok().body(
            EntityModel.of(entity,
                           linkTo(methodOn(AuthorController.class).showAuthor(entity.getId())).withSelfRel(),
                           linkTo(methodOn(AuthorController.class).showAllAuthors()).withRel("/authors")
            ));
    }

    @PutMapping(value = "/authors/{id}")
    public ResponseEntity<EntityModel<Author>> updateAuthor(@PathVariable long id, @RequestBody AuthorRecord author)
    {
        try
        {
            final Author entity = authorService.updateAuthor(author, id);
            return ResponseEntity.ok().body(
                EntityModel.of(entity,
                               linkTo(methodOn(AuthorController.class).showAuthor(id)).withSelfRel(),
                               linkTo(methodOn(AuthorController.class).showAllAuthors()).withRel("/authors")
                ));
        }
        catch (IOException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found", e);
        }
    }

    @DeleteMapping(value = "/authors/{id}")
    public ResponseEntity<EntityModel<Object>> deleteAuthor(@PathVariable("id") long id)
    {
        try
        {
            authorService.deleteAuthor(id);
            return ResponseEntity.ok().body(
                EntityModel.of(linkTo(methodOn(AuthorController.class).showAllAuthors()).withRel("/authors")
                ));
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found", e);
        }
    }

    @PatchMapping(value = "/authors/{id}")
    public ResponseEntity<EntityModel<Author>> partialUpdate(@RequestBody AuthorRecord partial, @PathVariable long id)
    {
        try
        {
            final Author entity = authorService.updateAuthor(partial, id);
            return ResponseEntity.ok().body(
                EntityModel.of(entity,
                               linkTo(methodOn(AuthorController.class).showAuthor(id)).withSelfRel(),
                               linkTo(methodOn(AuthorController.class).showAllAuthors()).withRel("/authors")
                ));
        }
        catch (IOException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found", e);
        }
    }
}