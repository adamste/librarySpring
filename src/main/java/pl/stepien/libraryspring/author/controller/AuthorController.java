package pl.stepien.libraryspring.author.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.stepien.libraryspring.author.model.AuthorRecord;
import pl.stepien.libraryspring.author.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController
{
    private final AuthorService authorService;

    @GetMapping(value = "/authors")
    public ResponseEntity<CollectionModel<AuthorRecord>> getAll()
    {
        final List<AuthorRecord> authorsRecords = authorService.getAuthorsRecords();
        return ResponseEntity.status(HttpStatus.OK).body(CollectionModel.of(authorsRecords,
                                                                            linkTo(
                                                                                methodOn(AuthorController.class).getAll())
                                                                                .withRel("/authors")));
    }

    @GetMapping(value = "/authors/{id}")
    public ResponseEntity<EntityModel<AuthorRecord>> getAuthor(@PathVariable("id") long id)
    {
        return authorService.getById(id)
                            .map(author -> ResponseEntity.ok().body(
                                EntityModel.of(author,
                                               linkTo(methodOn(AuthorController.class).getAuthor(id)).withSelfRel(),
                                               linkTo(methodOn(AuthorController.class).getAll()).withRel("/authors")
                                ))).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/authors")
    public ResponseEntity<EntityModel<AuthorRecord>> createAuthor(@RequestBody AuthorRecord author)
    {
        final AuthorRecord record = authorService.createAuthor(author);
        return ResponseEntity.ok().body(
            EntityModel.of(record,
                           linkTo(methodOn(AuthorController.class).getAuthor(record.getId())).withSelfRel(),
                           linkTo(methodOn(AuthorController.class).getAll()).withRel("/authors")
            ));
    }

    @PutMapping(value = "/authors/{id}")
    public ResponseEntity<EntityModel<AuthorRecord>> updateAuthor(@PathVariable long id, @RequestBody AuthorRecord author)
    {
        final AuthorRecord updated = authorService.updateAuthor(author, id);
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
    public ResponseEntity<EntityModel<AuthorRecord>> partialUpdate(@PathVariable boolean alive, @PathVariable long id)
    {
        final AuthorRecord author = authorService.patchAlive(alive, id);
        return ResponseEntity.ok().body(
            EntityModel.of(author,
                           linkTo(methodOn(AuthorController.class).getAuthor(id)).withSelfRel(),
                           linkTo(methodOn(AuthorController.class).getAll()).withRel("/authors")
            ));
    }
}