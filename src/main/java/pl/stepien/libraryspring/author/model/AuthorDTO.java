package pl.stepien.libraryspring.author.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.stepien.libraryspring.validator.PeselValid;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AuthorDTO {
    private final Long id;
    @NotBlank(message = "You have to provide a correct name")
    private final String name;
    @NotBlank(message = "You have to provide a correct surname")
    private final String surname;
    private final String country;
    @PeselValid
    private final Long pesel;
    private final boolean isAlive;
}
