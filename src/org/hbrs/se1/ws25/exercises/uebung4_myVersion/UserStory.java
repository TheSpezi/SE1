package org.hbrs.se1.ws25.exercises.uebung4_myVersion;

import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions.UserStoryException;

import java.io.Serial;
import java.io.Serializable;

public class UserStory implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    private static int IDCounter = 100;

    private int id;
    private String title;
    private String acceptance;
    private double prio;
    private String project;


    /* create user story*/
    public UserStory(String title, String acceptance, String project, int value, int penalty, int expense, int risk) throws UserStoryException{

        if (value < 1 || value > 5) throw new UserStoryException("Ungueltiger Wert fuer Mehrwert!", UserStoryException.ExceptionType.IllegalArgument);
        else if (penalty < 1 || penalty > 5) throw new UserStoryException("Ungueltiger Wert fuer Strafe!", UserStoryException.ExceptionType.IllegalArgument);
        else if (expense < 0) throw new UserStoryException("Negativer Wert fuer Aufwand!", UserStoryException.ExceptionType.IllegalArgument);
        else if (risk < 1 || risk > 5) throw new UserStoryException("Ungueltiger Wert fuer Risiko!", UserStoryException.ExceptionType.IllegalArgument);


        this.id = IDCounter++;
        this.title = title;
        this.acceptance = acceptance;
        this.project = project;
        this.prio = glogerCalc(value, penalty, expense, risk);

    }


    /*calc of prio after gloger*/
    private double glogerCalc(int value, int penalty, int expense, int risk) throws UserStoryException{
        double gloger = (double) (value + penalty) / (expense + risk);

        if(gloger < 0){
            throw new UserStoryException("Negativer Wert fuer Prioritaet!", UserStoryException.ExceptionType.NegativeValue);
        }

        return gloger;
    }

    /*
    @Override
    public String toString(){
        return String.format("%f | %s | %s | %s", this.prio, this.title, this.acceptance, this.project);
    }
    */
    public static void setIDCounter(int newIDStart){
        IDCounter = newIDStart;
    }

    public int getID() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAcceptance() {
        return this.acceptance;
    }

    public double getPrio() {
        return this.prio;
    }

    public String getProject() {
        return this.project;
    }
}
