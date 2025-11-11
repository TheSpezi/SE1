package org.hbrs.se1.ws25.exercises.uebung4_myVersion;

import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Interfaces.PersistenceStrategy;
import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions.ContainerException;
import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions.PersistenceException;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<UserStory> list = new ArrayList<>();
    private static Container INSTANCE;
    private PersistenceStrategy<UserStory> strat;

    private Container() {
    }

    /*get Instance*/
    public synchronized static Container getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new Container();

        }
        return INSTANCE;
    }

    public int getSize(){
        return this.list.size();
    }

    public List<UserStory> getList(){
        return list;
    }

    /*set persistence strat for container*/
    public void setPersistance(PersistenceStrategy<UserStory> st){
        this.strat = st;
    }


    /*add a user story to container*/
    public void addUserStory(UserStory elem) throws ContainerException{

        for (UserStory e : list){
            if (e.getID() == elem.getID()){
                throw new ContainerException(ContainerException.ExceptionType.duplicateElement);
            }
        }
        list.add(elem);
    }

    //FIXME:nicht getestet
    /*delete user story via id*/
    public void deleteElement(int id) throws ContainerException{

        for (UserStory e : list){
            if(e.getID() == id){
                list.remove(e);
            }
        }
        throw new ContainerException(ContainerException.ExceptionType.elementNotFound);

    }

    //FIXME:funktioniert nicht, nicht getestet
    /*delete user story via us object*/
    public void deleteElement(UserStory us) throws ContainerException{

        for (UserStory e : list){
            if(e.equals(us)){
                list.remove(us);
            }
        }
        throw new ContainerException(ContainerException.ExceptionType.elementNotFound);
    }

    /*store user stories in file*/
    public void store(String filename) throws PersistenceException{
        if(strat == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine Persistent-Strategie gesetzt!");
        }
            this.strat.save(list, filename);
    }

    /*load user stories from file*/
    public void load(String filename) throws PersistenceException{
        if (this.strat == null){
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine Persistent-Strategie gesetzt!");
        }
        this.list = strat.load(filename);

        int lastID = this.list.get(this.list.size() -1).getID();
        UserStory.setIDCounter(lastID + 1);
    }

    /*check if list already contains user story*/
    public boolean contains(UserStory us){
        return list.contains(us);
    }

    public void deleteAll(){
        this.list.clear();
    }



}
