package uk.fowl.goose.exceptions;

public class GooseNotFoundException extends RuntimeException {
    public GooseNotFoundException(String message) {
        super(message);
    }
}
