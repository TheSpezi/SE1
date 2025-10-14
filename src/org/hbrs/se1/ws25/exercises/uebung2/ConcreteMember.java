package org.hbrs.se1.ws25.exercises.uebung2;


public class ConcreteMember implements Member {

    /*Klassenvariablen*/
    private static int ID_Counter = 1;

    /*Instanzvariablen*/
    private int id;

    /*Konstruktor*/
    public ConcreteMember(){
        id = ID_Counter++;
    }

    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Member (ID = "+ this.id+")";
    }
}
