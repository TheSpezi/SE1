package org.hbrs.se1.ws25.exercises.uebung9;

import java.util.ArrayList;
import java.util.List;

public class ComplexDocument extends Document{

    private List<Document> docList = new ArrayList<>();

    public void addDoc(Document doc){
        docList.add(doc);
    }

    public void rmDoc(Document doc){
        docList.remove(doc);
    }

    @Override
    public int getSize() {
        int ges = 0;
        for(Document d : docList){
            ges += d.getSize();
        }
        return ges;
    }
}
