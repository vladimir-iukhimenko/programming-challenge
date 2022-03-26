package de.exxcellent.challenge.exception;

public class ReadFileException extends RuntimeException {
    public ReadFileException() {
        super();
    }

    public ReadFileException(String message) {
        super(message);
    }
}
