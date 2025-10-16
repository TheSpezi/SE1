package org.hbrs.se1.ws25.exercises.uebung2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContainerTest {

    static Container c;
    static ConcreteMember m1;
    static ConcreteMember m2;

    @BeforeAll
    static void init() {
        c = new Container();
        m1 = new ConcreteMember();
        m2 = new ConcreteMember();
    }

    @Test
    @Order(1)
    void leer() {
        assertEquals(0, c.size());
        assertEquals("FEHLER: Kein Member mit der ID: " + m1.getID() + " gefunden!", c.deleteMember(m1.getID()));

    }

    @Test
    @Order(2)
    void eins() {
        c.addMember(m1);
        assertEquals(1, c.size());
        assertThrows(ContainerException.class, () -> c.addMember(m1));
        assertEquals(1, c.size());

        //visuelle Kontrolle via dump
        c.dump();
        System.out.println("Member (ID = " + m1.getID() + ")");
        System.out.println();

    }

    @Test
    @Order(3)
    void zwei() {
        c.addMember(m2);
        assertEquals(2, c.size());
        assertThrows(ContainerException.class, () -> c.addMember(m2));


        //visuelle Kontrolle via dump
        c.dump();
        System.out.println("Member (ID = " + m1.getID() + ")\nMember (ID = " + m2.getID() + ")");
        System.out.println();
    }

    @Test
    @Order(4)
    void delete_eins() {
        c.deleteMember(m1.getID());
        assertEquals(1, c.size());
        assertEquals("FEHLER: Kein Member mit der ID: " + m1.getID() + " gefunden!", c.deleteMember(m1.getID()));
        assertEquals(1, c.size());
    }

    @Test
    @Order(5)
    void delete_zwei() {
        c.deleteMember(m2.getID());
        assertEquals(0, c.size());
        assertEquals("FEHLER: Kein Member mit der ID: " + m2.getID() + " gefunden!", c.deleteMember(m2.getID()));
        assertEquals(0, c.size());


    }
}
