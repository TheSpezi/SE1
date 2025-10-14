package org.hbrs.se1.ws25.exercises.uebung1.control;

public class Fabrik {

    static public Translator createTranslator() {
        GermanTranslator t = new GermanTranslator();
        t.setDate("Okt/2025");
        return t;
    }

}
