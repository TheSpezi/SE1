package org.hbrs.se1.ws25.exercises.uebung4_myVersion;

import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Interfaces.PersistenceStrategy;

public class Main {

    public static void main(String[] args) {

        Container c = Container.getInstance();
        PersistenceStrategy<UserStory> ps = new PersistenceStrategyStream<>();
        c.setPersistance(ps);

        UserInput u = new UserInput();
        u.input();
    }
}
