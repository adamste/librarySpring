package pl.stepien.libraryspring.author.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.stepien.libraryspring.author.model.AuthorDTO;
import pl.stepien.libraryspring.author.service.AuthorService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
class AuthorController {
    private final AuthorService authorService;

    @GetMapping(value = "/authors")
    public ResponseEntity<CollectionModel<AuthorDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                CollectionModel.of(authorService.getAuthorsRecords(),
                        linkTo(methodOn(AuthorController.class).getAll()).withRel("/authors")));
    }

    @GetMapping(value = "/authors/{id}")
    public ResponseEntity<EntityModel<AuthorDTO>> getAuthor(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(
                EntityModel.of(authorService.getById(id),
                        linkTo(methodOn(AuthorController.class).getAuthor(id)).withSelfRel(),
                        linkTo(methodOn(AuthorController.class).getAll()).withRel("/authors")
                ));
    }

    @PostMapping("/authors")
    public ResponseEntity<EntityModel<AuthorDTO>> createAuthor(@Valid @RequestBody AuthorDTO author)
    {
        return ResponseEntity.ok().body(
                EntityModel.of(authorService.createAuthor(author),
                        linkTo(methodOn(AuthorController.class).getAuthor(
                                authorService.createAuthor(author).getId())).withSelfRel(),
                        linkTo(methodOn(AuthorController.class).getAll()).withRel("/authors")
                ));
    }

    @PutMapping(value = "/authors/{id}")
    public ResponseEntity<EntityModel<AuthorDTO>> updateAuthor(@PathVariable long id, @Valid @RequestBody AuthorDTO author)
    {
        return ResponseEntity.ok().body(
                EntityModel.of(authorService.updateAuthor(author, id),
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
        return ResponseEntity.ok().body(
                EntityModel.of(authorService.patchAlive(alive, id),
                        linkTo(methodOn(AuthorController.class).getAuthor(id)).withSelfRel(),
                        linkTo(methodOn(AuthorController.class).getAll()).withRel("/authors")
                ));
    }
}