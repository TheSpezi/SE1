package org.hbrs.se1.ws25.exercises.uebung2;

import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws25.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerReadWriteTest {

    private Container container;

    @BeforeEach
    void init() {
        container = Container.getInstance();
    }

    @Test //Test auf nicht Implementierung
    void testMongoDBNotImplementedSolution() {
        container.setPersistence(new PersistenceStrategyMongoDB<>());
        PersistenceException e = assertThrows(PersistenceException.class, () -> container.store());
        assertEquals("MongoDB nicht implementiert!", e.getMessage());
    }

    @Test //Test auf keine festgelegte Persistenz-Strategie
    void testNoStrategySet() {
        container.setPersistence(null);
        PersistenceException e = assertThrows(PersistenceException.class, () -> container.store());
        assertEquals("Keine Persistenz-Strategie gesetzt!", e.getMessage());

    }

    @Test //Falsche Location fuer geschriebene Dateien festlegen
    void testWrongLocationOfFile() {
        PersistenceStrategyStream<Member> ps = new PersistenceStrategyStream<>();
        ps.setLocation("/tmp");
        container.setPersistence(ps);
        PersistenceException e = assertThrows(PersistenceException.class, () -> container.store());
        assertEquals(PersistenceException.ExceptionType.WriteNotSuccessful, e.getExceptionTypeType());
    }

    @Test //Ablauf Test
    void testStoreDeleteAndLoad() throws ContainerException, PersistenceException {
        container.deleteAllMembers();
        PersistenceStrategyStream<Member> ps = new PersistenceStrategyStream<>();
        container.setPersistence(ps);

        assertEquals(0, container.size());

        ConcreteMember m1 = new ConcreteMember();
        container.addMember(m1);
        assertTrue(container.contains(m1));
        assertEquals(1, container.size());
        container.store();
        container.deleteAllMembers();
        assertEquals(0, container.size());
        container.load();
        assertTrue(container.contains(m1));
        assertEquals(1, container.size());


    }
}

