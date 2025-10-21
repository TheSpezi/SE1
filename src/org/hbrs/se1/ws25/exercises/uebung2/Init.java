package org.hbrs.se1.ws25.exercises.uebung2;

import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategyStream;

public class Init {

    /*
     * Initialisiert den Container und eine Persistenz-Strategie
     */
    public static void initContainer() {
        Container container = Container.getInstance();

        PersistenceStrategy<Member> p = new PersistenceStrategyStream<>();
        container.setPersistence(p);
    }

}
