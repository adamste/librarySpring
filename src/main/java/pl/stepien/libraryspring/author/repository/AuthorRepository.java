package pl.stepien.libraryspring.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.stepien.libraryspring.author.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>
{
}
