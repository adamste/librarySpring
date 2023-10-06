package pl.stepien.libraryspring.author.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public static final AuthorNotFoundException NO_ID = new AuthorNotFoundException("No user with that id");
    public static final AuthorNotFoundException NO_UPDATE = new AuthorNotFoundException("Won't update since no such user");
    public static final AuthorNotFoundException NO_DELETE = new AuthorNotFoundException("Won't delete since no such user");

    private AuthorNotFoundException(String message) {
        super(message);
    }
}
