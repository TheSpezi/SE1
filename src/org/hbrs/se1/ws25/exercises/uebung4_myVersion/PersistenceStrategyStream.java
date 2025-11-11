package org.hbrs.se1.ws25.exercises.uebung4_myVersion;

import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions.PersistenceException;
import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Interfaces.PersistenceStrategy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    /*name of file stored*/
    private String location = "Saved_UserStories";

    /*change name of store file*/
    public void setLocation(String l) {
        this.location = l;
    }

    /*stores the list*/
    @Override
    public void save(List<E> list, String filename) throws PersistenceException {

        if(filename.equals("")) filename = this.location;
        try (FileOutputStream fos = new FileOutputStream(filename + ".ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(list);

        } catch (Exception e) {
            throw new PersistenceException(PersistenceException.ExceptionType.WriteNotSuccessful, e.getMessage());
        }
    }

    /*loads the list*/
    @Override
    public List<E> load(String filename) throws PersistenceException {

        if(filename.equals("")) filename = this.location;
        try (FileInputStream fis = new FileInputStream(filename + ".ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Object obj = ois.readObject();
            List<E> newList;

            if (obj instanceof List<?>) {
                newList = (List<E>) obj;
                return newList;
            }
        } catch (Exception e) {
            throw new PersistenceException(PersistenceException.ExceptionType.ReadNotSuccessful, e.getMessage());
        }

        return null;
    }

}
