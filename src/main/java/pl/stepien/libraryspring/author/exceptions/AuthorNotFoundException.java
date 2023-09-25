package pl.stepien.libraryspring.author.exceptions;

public class AuthorNotFoundException extends RuntimeException
{
    public AuthorNotFoundException(String message) {
        super(message);
    }
}
