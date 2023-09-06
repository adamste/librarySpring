package pl.stepien.libraryspring.author.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String surname;

    private String country;

    public Author()
    {
    }

    public Author(final String name, final String surname, final String country)
    {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(final String surnname)
    {
        this.surname = surnname;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(final String country)
    {
        this.country = country;
    }
}
