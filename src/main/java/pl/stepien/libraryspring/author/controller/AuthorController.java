package pl.stepien.libraryspring.author.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import pl.stepien.libraryspring.author.exceptions.AuthorNotFoundException;
import pl.stepien.libraryspring.author.model.AuthorDTO;
import pl.stepien.libraryspring.author.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController
{
    private final AuthorService authorService;

    @GetMapping(value = "/authors")
    public ResponseEntity<CollectionModel<AuthorDTO>> getAll()
    {
        final List<AuthorDTO> authorsRecords = authorService.getAuthorsRecords();
        return ResponseEntity.status(HttpStatus.OK).body(CollectionModel.of(authorsRecords,
                                                                            linkTo(
                                                                                methodOn(AuthorController.class).getAll())
                                                                                .withRel("/authors")));
    }

    @GetMapping(value = "/authors/{id}")
    public ResponseEntity<EntityModel<AuthorDTO>> getAuthor(@PathVariable("id") long id)
    {
        return authorService.getById(id)
                            .map(author -> ResponseEntity.ok().body(
                                EntityModel.of(author,
                                               linkTo(methodOn(AuthorController.class).getAuthor(id)).withSelfRel(),
                                               linkTo(methodOn(AuthorController.class).getAll()).withRel("/authors")
                                ))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/authors")
    public ResponseEntity<EntityModel<AuthorDTO>> createAuthor(@Valid @RequestBody AuthorDTO author)
    {
        final AuthorDTO record = authorService.createAuthor(author);
        return ResponseEntity.ok().body(
            EntityModel.of(record,
                           linkTo(methodOn(AuthorController.class).getAuthor(record.getId())).withSelfRel(),
                           linkTo(methodOn(AuthorController.class).getAll()).withRel("/authors")
            ));
    }

    @PutMapping(value = "/authors/{id}")
    public ResponseEntity<EntityModel<AuthorDTO>> updateAuthor(@PathVariable long id, @Valid @RequestBody AuthorDTO author)
    {
        final AuthorDTO updated = authorService.updateAuthor(author, id);
        return ResponseEntity.ok().body(
            EntityModel.of(updated,
                           linkTo(methodOn(AuthorController.class).getAuthor(id)).withSelfRel(),
                           linkTo(methodOn(AuthorController.class).getAll()).withRel("/authors")
            ));
    }

    @DeleteMapping(value = "/authors/{id}")
    public ResponseEntity<EntityModel<Object>> deleteAuthor(@PathVariable("id") long id)
    {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().body(
            EntityModel.of(linkTo(methodOn(AuthorController.class).getAll()).withRel("/authors")
            ));
    }

    @PatchMapping(value = "/authors/{id}/alive/{alive}")
    public ResponseEntity<EntityModel<AuthorDTO>> partialUpdate(@PathVariable boolean alive, @PathVariable long id)
    {
        final AuthorDTO author = authorService.patchAlive(alive, id);
        return ResponseEntity.ok().body(
            EntityModel.of(author,
                           linkTo(methodOn(AuthorController.class).getAuthor(id)).withSelfRel(),
                           linkTo(methodOn(AuthorController.class).getAll()).withRel("/authors")
            ));
    }
}