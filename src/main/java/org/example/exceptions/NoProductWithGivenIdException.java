package org.example.exceptions;

public class NoProductWithGivenIdException extends RuntimeException {
    public NoProductWithGivenIdException(String message) {
        super(message);
    }
}
