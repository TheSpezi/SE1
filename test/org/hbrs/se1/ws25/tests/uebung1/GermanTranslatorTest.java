package org.hbrs.se1.ws25.tests.uebung1;

import org.hbrs.se1.ws25.exercises.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GermanTranslatorTest {

    static GermanTranslator g;

    //Init
    @BeforeAll
     static void init() {
        g = new GermanTranslator();
    }

    //Gueltige Zahlenwerte
    @Test
    void gAEK() {
        assertEquals(g.translateNumber(2), "zwei");
    }

    //Werte kleiner als 1
    @Test
    void uAEK1() {
        assertEquals(g.translateNumber(-1), "Übersetzung der Zahl -1 nicht möglich 1.0");

    }

    //Werte groeßer als 10
    @Test
    void uAEK2() {
        assertEquals(g.translateNumber(15), "Übersetzung der Zahl 15 nicht möglich 1.0");

    }
    /*
        Eigentlich wollte ich hier noch mit Kommazahlen testen, geht aber schlecht. Bzw. ich habe keinen Weg gefunden
        irgendwie Kommazahlen zu testen.
    //Nicht ganzzahlige Zahlenwerte
    @Test
    void uAEK3() {
        //assertThrows(RuntimeException.class, () -> g.translateNumber(3.5));
    }
    */

    //NaN und andere ungueltige Datentypen
    @Test
    void uAEK4() {
        Integer i = null;
        assertThrows(Exception.class, () -> g.translateNumber(i));
    }

    //Besondere Grenzwerte
    @Test
    void grenzwerte() {
        assertEquals(g.translateNumber(10), "zehn");
        assertEquals(g.translateNumber(1), "eins");
        assertEquals(g.translateNumber(11), "Übersetzung der Zahl 11 nicht möglich 1.0");
        assertEquals(g.translateNumber(0), "Übersetzung der Zahl 0 nicht möglich 1.0");
    }
}