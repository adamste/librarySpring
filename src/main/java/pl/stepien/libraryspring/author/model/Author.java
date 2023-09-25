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

    private Long pesel;

    private boolean isAlive;

    public static class Factory
    {
        public static Author create(AuthorRecord authorRecord)
        {
            return new Author(null, authorRecord.getName(), authorRecord.getSurname(), authorRecord.getCountry(),
                              authorRecord.getPesel(), authorRecord.isAlive());
        }
    }
}
