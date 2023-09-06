package pl.stepien.libraryspring.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.stepien.libraryspring.author.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>
{
}
