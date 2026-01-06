package org.hbrs.se1.ws25.exercises.uebung9;

public class TestClient {

    public static void main(String[] args) {

        ComplexDocument doc0 = new ComplexDocument();
        doc0.setID(0);

        TextDocument doc2 = new TextDocument("Die Klausur im Fach SE findet bald im März 2026 statt!", TextDocument.Encoding.UTF16);
        doc2.setID(2);

        ComplexDocument doc3 = new ComplexDocument();
        doc3.setID(3);

        TextDocument doc5 = new TextDocument("Software Engineering I ist eine Vorlesung in den Studiengaengen BWI und BCSP!", TextDocument.Encoding.UTF32);
        doc5.setID(5);

        GraficDocument doc4 = new GraficDocument("localhost:8080");
        doc4.setID(4);

        doc3.addDoc(doc4);
        doc3.addDoc(doc5);

        doc0.addDoc(doc2);
        doc0.addDoc(doc3);

        int groesse = doc0.getSize();
        System.out.println("Groesse aller Documents: " + groesse + " Bytes.");


    }
}
