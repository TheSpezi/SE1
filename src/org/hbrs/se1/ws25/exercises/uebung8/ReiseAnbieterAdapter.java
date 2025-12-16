package org.hbrs.se1.ws25.exercises.uebung8;

public class ReiseAnbieterAdapter implements ExternalHotelsuche{

    private ReiseAnbieterSystem reiseAnbeiterSystem;

    public ReiseAnbieterAdapter(ReiseAnbieterSystem system){
        this.reiseAnbeiterSystem = system;
    }

    public SuchErgebnis suche(SuchAuftrag s){
        QueryObject qo = convertIn(s);
        QueryResult qr = reiseAnbeiterSystem.executeQuery(qo);
        return convertOut(qr);
    }

    private QueryObject convertIn(SuchAuftrag s){
       // Transform hier
        return new QueryObject();
    }

    private SuchErgebnis convertOut(QueryResult qr){
        //Transform hier
        return new SuchErgebnis();
    }


}
