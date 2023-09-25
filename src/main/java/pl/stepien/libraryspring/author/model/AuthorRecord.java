package pl.stepien.libraryspring.author.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AuthorRecord
{
    private Long id;
    private String name;
    private String surname;
    private String country;
    private Long pesel;
    private boolean isAlive;
}
