package org.hbrs.se1.ws25.exercises.uebung2;

import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategy;

import java.util.ArrayList;
import java.util.List;

public class Container {

    /*Klassenvariablen*/
    List<Member> list = new ArrayList<>();
    private static Container instance;
    private PersistenceStrategy<Member> strat;


    /*privater Konstruktor*/
    private Container() {
    }

    /*Singleton */
    public static Container getInstance() {
        synchronized (instance) {        //synchronized = eine atomare funktion, thread-sicherheit / Kontextwechsel! Kann auch im Methodenkopf stehen
            if (instance == null) {
                instance = new Container();
            }
        }
        return instance;
    }

    /* setzen der Persistenz-Strategie*/
    public void setPersistence(PersistenceStrategy<Member> strategy) {
        this.strat = strategy;
    }


    /*Hinzufuegen eines Members*/
    public void addMember(ConcreteMember member) throws ContainerException {

        for (Member m : list) {
            if (m.getID().equals(member.getID())) {
                throw new ContainerException(member.getID());
            }
        }

        list.add(member);
    }

    /*Löschen eines Members*/
    public String deleteMember(int id) {

        for (Member m : list) {
            if (m.getID().equals(id)) {
                list.remove(m);
                return null;
            }
        }
        return "FEHLER: Kein Member mit der ID: " + id + " gefunden!";
    }


    public List<Member> getCurrentList() {
        return list;
    }

    /*Anzahl der Member*/
    public int size() {
        return this.list.size();
    }

    /*speichern der Elemente*/
    public void store() throws PersistenceException {
        if (strat == null)
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine Persistenz-Strategie gesetzt!");
        strat.save(list);
        System.out.println("Member erfolgreich abgespeichert.");
    }

    /*laden der gespeicherten Elemente*/
    public void load() throws PersistenceException {
        if (strat == null)
            throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine Persistenz-Strategie gesetzt!");
        this.list = strat.load(); //überschreiben der aktuellen Member durch die eingelesenen
    }

    /*loeschen aller Members*/
    public void deleteAllMembers() {
        list.clear();
    }

    /*testet ob ein Member in der liste enthalten ist*/
    public boolean contains(Member testMember) {
        for (Member m : list) {
            if (m.getID().equals(testMember.getID())) return true;
        }
        return false;
    }
}
