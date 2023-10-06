package pl.stepien.libraryspring.author.service;

import pl.stepien.libraryspring.author.model.Author;
import pl.stepien.libraryspring.author.model.AuthorDTO;

public class AuthorMapper {

    static AuthorDTO mapEntityToDTO(Author entity) {
        return new AuthorDTO(entity.getId(), entity.getName(), entity.getSurname(),
                entity.getCountry(), entity.getPesel(), entity.isAlive());
    }
}