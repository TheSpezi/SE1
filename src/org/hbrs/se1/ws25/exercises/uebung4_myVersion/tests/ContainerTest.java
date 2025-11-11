package org.hbrs.se1.ws25.exercises.uebung4_myVersion.tests;

import org.hbrs.se1.ws25.exercises.uebung4_myVersion.*;
import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions.ContainerException;
import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions.PersistenceException;
import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Exceptions.UserStoryException;
import org.hbrs.se1.ws25.exercises.uebung4_myVersion.Interfaces.PersistenceStrategy;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContainerTest {


    static PersistenceStrategy<UserStory> ps;
    static Container c;
    static UserStory us1;


    @BeforeAll
    static void init() throws UserStoryException {
        c = Container.getInstance();
        us1 = new UserStory("Titel1", "Akz1", "Projekt1", 1, 1, 1, 1);
        ps = new PersistenceStrategyStream<>();
    }

    @BeforeEach
    void clear(){
        c.deleteAll();
    }

    @Order(-1)
    @Test
    void persistence(){
        PersistenceException e = assertThrows(PersistenceException.class, () -> c.store("x"));
        assertEquals(PersistenceException.ExceptionType.NoStrategyIsSet, e.getType());
        c.setPersistance(ps);
    }

    @Order(0)
    @Test
    void empty(){
        assertEquals(0,c.getSize());
        assertTrue(c.getList().isEmpty());
    }

    @Order(1)
    @Test
    void addUS() throws ContainerException {
        c.addUserStory(us1);
        assertEquals(1,c.getSize());
        assertFalse(c.getList().isEmpty());


    }

    @Order(2)
    @Test
    void store() throws PersistenceException, ContainerException {
        c.addUserStory(us1);
        c.store("store_test");
        assertEquals(us1.getID(),c.getList().get(0).getID());

    }

    @Order(3)
    @Test
    void load() throws PersistenceException {
        c = null;
        c = Container.getInstance();
        c.setPersistance(ps);
        c.load("store_test");
    assertEquals(1, c.getSize());
    assertEquals(us1.getID(),c.getList().get(0).getID());
    }
}