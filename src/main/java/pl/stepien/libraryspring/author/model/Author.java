package pl.stepien.libraryspring.author.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author
{
    @Id
    @SequenceGenerator(name = "author_generator", sequenceName = "AUTHOR_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    private Long id;

    private String name;

    private String surname;

    private String country;

    public Author(String name, String surname, String country)
    {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
