package org.hbrs.se1.ws25.exercises.uebung4_myVersion.Interfaces;


import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions.PersistenceException;

import java.util.List;

public interface PersistenceStrategy<E> {
    public void save(List<E> list, String filename) throws PersistenceException;
    public List<E> load(String filename) throws PersistenceException;
}
