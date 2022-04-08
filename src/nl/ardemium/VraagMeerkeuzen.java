package nl.ardemium;

import java.util.ArrayList;

public class VraagMeerkeuzen extends Vraag{

    private String antwoord;
    private ArrayList<String> antwoordFouten;

    public VraagMeerkeuzen(String naam, String antwoord, ArrayList<String> antwoordFouten) {
        super(naam);
        this.antwoord = antwoord;
        this.antwoordFouten = antwoordFouten;
    }

    public String getAntwoord() {
        return antwoord;
    }

    public ArrayList<String> getAntwoordFouten() {
        return antwoordFouten;
    }
}
