package org.hbrs.se1.ws25.exercises.uebung9;

public abstract class Document {

    private int id;

    public int getID(){
        return id;
    }

    public void setID(int id){
        this.id = id;
    }


    public abstract int getSize();
}
