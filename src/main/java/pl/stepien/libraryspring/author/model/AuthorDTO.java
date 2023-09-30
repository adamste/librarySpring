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
public class AuthorDTO
{
    private Long id;
    @NotBlank(message = "You have to provide a correct name")
    private String name;
    @NotBlank(message = "You have to provide a correct surname")
    private String surname;
    private String country;
    @PeselValid
    private Long pesel;
    private boolean isAlive;
}
