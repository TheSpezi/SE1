package org.hbrs.se1.ws25.tests.uebung10;

import org.hbrs.se1.ws25.exercises.uebung10.stackAufagbe.EigenerStack;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EigenerStackTest {


    private static EigenerStack stack;


    @BeforeAll
    static void init() {
        stack = new EigenerStack<Integer>(4);
    }

    @Order(1)
    @Test
    void testEmpty() {
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Order(2)
    @Test
    void testBefuellen() {
        stack.push(1);
        stack.push(2);
        assertEquals(2,stack.size());
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.size());
    }
    @Order(3)
    @Test
    void testUeberfuellen() {
        assertThrows(IndexOutOfBoundsException.class, () -> stack.push(5));
        assertEquals(4, stack.size());
    }

    @Order(4)
    @Test
    void testLeeren() {
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.size());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(0, stack.size());
    }
}
