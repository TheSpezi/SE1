package org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions;

public class PersistenceException extends Exception {

    private ExceptionType exceptionType;

    public enum ExceptionType{
        ImplementationNotAvailable, ConnectionNotAvailable, NoStrategyIsSet, WriteNotSuccessful,
        ReadNotSuccessful
    }

    public PersistenceException(ExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }

    public ExceptionType getType(){
        return this.exceptionType;
    }

}
