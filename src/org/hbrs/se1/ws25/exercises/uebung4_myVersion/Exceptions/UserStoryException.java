package org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions;

public class UserStoryException extends Exception {

    private ExceptionType type;

    public enum ExceptionType{
        IllegalArgument, NegativeValue
    }

    public UserStoryException(String message, ExceptionType type) {
        super(message);
        this.type = type;

    }

    public ExceptionType getType(){
        return this.type;
    }
}
