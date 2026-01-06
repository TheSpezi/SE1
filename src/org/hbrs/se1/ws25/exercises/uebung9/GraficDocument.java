package org.hbrs.se1.ws25.exercises.uebung9;

public class GraficDocument extends CoreDocument{

    private String url;

    public GraficDocument(String url){
        this.url = url;
    }

    @Override
    public int getSize() {
        return 1200;
    }
}
