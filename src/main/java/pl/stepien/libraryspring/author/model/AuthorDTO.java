package pl.stepien.libraryspring.author.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.stepien.libraryspring.validator.ValidPesel;

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
    @ValidPesel
    private Long pesel;
    private boolean isAlive;
}
