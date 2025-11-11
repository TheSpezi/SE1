package org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions;


public class ContainerException extends Exception {

    private ExceptionType type;
    private String msg;

    public enum ExceptionType {
        duplicateElement, elementNotFound
    }

    public ContainerException(ExceptionType exceptionType) {
        this.type = exceptionType;

        switch (type) {

            case duplicateElement:
                this.msg = "Diese User Story ist bereits hinterlegt!";
            case elementNotFound:
                this.msg = "Diese User Story wurde nicht gefunden!";
        }
    }

    public ExceptionType getType(){
        return type;
    }

    public String getMsg(){
        return msg;
    }


}
