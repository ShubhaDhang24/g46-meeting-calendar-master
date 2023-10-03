package se.lexicon.exception;

public class AuthenticateFailedException  extends  Exception{


    public AuthenticateFailedException(String message) {
        super(message);
    }

    public AuthenticateFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
