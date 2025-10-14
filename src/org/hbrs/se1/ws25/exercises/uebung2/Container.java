package org.hbrs.se1.ws25.exercises.uebung2;

import java.util.ArrayList;
import java.util.List;

public class Container {

    List<ConcreteMember> list = new ArrayList<>();

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
            if (m.getID() == id) {
                list.remove(m);
                return null;
            }
        }
        return "FEHLER: Kein Member mit der ID: " + id + " gefunden!";
    }


    /*Ausgabe aller Member-Ids*/
    public void dump() {

        for (Member m : list) {
            System.out.println(m);
        }
    }

    /*Anzahl der Member*/
    public int size() {
        return this.list.size();
    }


}
