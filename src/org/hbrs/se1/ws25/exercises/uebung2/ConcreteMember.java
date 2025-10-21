package org.hbrs.se1.ws25.exercises.uebung2;


import java.io.Serial;
import java.io.Serializable;

public class ConcreteMember implements Member, Serializable

{

    /*Klassenvariablen*/
    @Serial
    private static final long serialVersionUID = 1L;


    private static int ID_Counter = 1;

    /*Instanzvariablen*/
    private int id;

    /*Konstruktor*/
    public ConcreteMember() {
        id = ID_Counter++;
    }

    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
    return "Member (ID = " + this.id + ")";
    }
}
