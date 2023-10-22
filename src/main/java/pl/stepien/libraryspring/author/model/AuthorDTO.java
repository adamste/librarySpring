package pl.stepien.libraryspring.author.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import pl.stepien.libraryspring.validator.PeselValid;

@Value
public class AuthorDTO {
    Long id;
    @NotBlank(message = "You have to provide a correct name")
    String name;
    @NotBlank(message = "You have to provide a correct surname")
    String surname;
    String country;
    @PeselValid
    Long pesel;
    boolean isAlive;
}
