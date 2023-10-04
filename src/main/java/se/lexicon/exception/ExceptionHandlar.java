package se.lexicon.exception;

import se.lexicon.util.ConsoleColour;

public class ExceptionHandlar {
    public static void handleAllException(Exception exception)
    {
        if(exception instanceof AuthenticateFailedException)
        {
            System.out.println(exception.getMessage());
        } else if (exception instanceof MySqlException) {
            System.out.println(ConsoleColour.RED+exception.getMessage()+ConsoleColour.RESET);

        } else if (exception instanceof UserExpiredException) {
            System.out.println(exception.getMessage());

        } else if (exception instanceof DbConnectionException) {
            System.out.println(exception.getMessage());

        } else
        {
            System.out.println("Unexpected error found");
            System.out.println(exception.getStackTrace());
        }
    }
}
