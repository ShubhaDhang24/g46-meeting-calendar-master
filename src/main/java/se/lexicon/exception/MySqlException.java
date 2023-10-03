package se.lexicon.exception;

public class MySqlException extends RuntimeException{
    public MySqlException(String message) {
        super(message);
    }

    public MySqlException(String message, Throwable cause) {
        super(message, cause);
    }
}
