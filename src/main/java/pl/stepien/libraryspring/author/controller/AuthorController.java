package pl.stepien.libraryspring.author.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.stepien.libraryspring.author.model.AuthorRecord;
import pl.stepien.libraryspring.author.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController
{
    private final AuthorService authorService;

    @GetMapping("/allAuthors")
    public List<AuthorRecord> showAllAuthors()
    {
        return authorService.getAuthorsRecords();
    }
}