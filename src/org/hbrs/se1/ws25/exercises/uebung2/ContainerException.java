package org.hbrs.se1.ws25.exercises.uebung2;

public class ContainerException extends RuntimeException{

    public ContainerException(int memberid){
        super("Das Member-Objekt mit der ID "+ memberid + " ist bereits vorhanden");
    }
}
