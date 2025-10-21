package org.hbrs.se1.ws25.exercises.uebung2;

import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTestV3 {

    private Container container;

    @BeforeEach
    void init() {
        container = Container.getInstance();

    }

    @Test
    void testMongoDBNotImplementedSolution() {
        container.setPersistence(new PersistenceStrategyMongoDB<Member>());
        PersistenceException e = assertThrows(PersistenceException.class, () -> container.store());
        assertEquals(e.getMessage(), "MongoDB nicht implementiert!");
    }

    @Test
    void testNoStrategySet() {
        container.setPersistence(null);
        PersistenceException e = assertThrows(PersistenceException.class, () -> container.store());
        assertEquals(e.getMessage(), "Keine Persistenz-Strategie gesetzt!");

    }

    @Test
    void testWrongLocationOfFile() {
        PersistenceStrategyStream<Member> ps = new PersistenceStrategyStream<>();
        ps.setLocation("/tmp");
        container.setPersistence(ps);
        PersistenceException e = assertThrows(PersistenceException.class, () -> container.store());
        assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable, e.getExceptionTypeType());
    }

    @Test
    void testStoreDeleteAndLoad() throws ContainerException, PersistenceException {
        container.deleteAllMembers();
        PersistenceStrategyStream<Member> ps = new PersistenceStrategyStream<>();
        container.setPersistence(ps);

        assertEquals(0, container.size());

        ConcreteMember m1 = new ConcreteMember();
        container.addMember(m1);

        assertEquals(1, container.size());
        container.store();
        container.deleteAllMembers();
        assertEquals(0, container.size());
        container.load();
        assertEquals(1, container.size());


    }
}

