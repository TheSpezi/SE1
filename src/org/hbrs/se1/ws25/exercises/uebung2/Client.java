package org.hbrs.se1.ws25.exercises.uebung2;

import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceException;

import java.util.List;

public class Client {

    public static void main(String[] args) throws ContainerException, PersistenceException {

        Init.initContainer();

        ConcreteMember m1 = new ConcreteMember();
        ConcreteMember m2 = new ConcreteMember();
        ConcreteMember m3 = new ConcreteMember();
        ConcreteMember m4 = new ConcreteMember();
        Container c = Container.getInstance();

        c.addMember(m1);
        c.addMember(m2);
        c.addMember(m3);
        c.addMember(m4);

        List<Member> liste = c.getCurrentList();
        MemberView mv = new MemberView();
        mv.dump(liste);

        c.store();
        c.load();
        mv.dump(c.getCurrentList());


    }
}
