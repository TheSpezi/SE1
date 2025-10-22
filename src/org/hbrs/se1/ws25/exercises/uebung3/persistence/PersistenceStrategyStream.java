package org.hbrs.se1.ws25.exercises.uebung3.persistence;
import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    private String location = "objects.ser";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /*
     * Method for saving a list of Member-objects to a disk (HDD)
     * Look-up in Google for further help! Good source:
     * https://www.digitalocean.com/community/tutorials/objectoutputstream-java-write-object-file
     * (Last Access: Oct, 13th 2025)
     */
    public void save(List<E> member) throws PersistenceException  {
        try {
            FileOutputStream fos = new FileOutputStream(location);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(member);
            oos.close();
            fos.close();
        } catch (Exception e){
            throw new PersistenceException(PersistenceException.ExceptionType.WriteNotSuccessful, e.getMessage());
        }


    }

    @Override
    /*
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException  {

        try{
            FileInputStream fis = new FileInputStream(location);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            List<E> newListe;

            if(o instanceof  List<?>){
                newListe = (List<E>) o;
                return newListe;
            }

            ois.close();
            fis.close();
        }catch(Exception e){
            throw new PersistenceException(PersistenceException.ExceptionType.ReadNotSuccessful, e.getMessage());

        }

        return null;
    }
}
