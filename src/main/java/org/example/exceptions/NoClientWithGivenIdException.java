package org.example.exceptions;

public class NoClientWithGivenIdException extends RuntimeException {
    public NoClientWithGivenIdException(String message) {
        super(message);
    }
}
