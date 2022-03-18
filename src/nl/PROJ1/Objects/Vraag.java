package nl.PROJ1.Objects;

import java.util.ArrayList;

public class Vraag {
    private final String VRAAG;
    private final String TYPE;
    private final String ANTWOORD;
    private ArrayList<String> fout;

    public Vraag(String VRAAG, String TYPE, String ANTWOORD, ArrayList<String> fout) {
        this.VRAAG = VRAAG;
        this.TYPE = TYPE;
        this.ANTWOORD = ANTWOORD;
        this.fout = fout;
    }

    public Vraag(String VRAAG, String TYPE, String ANTWOORD) {
        this.VRAAG = VRAAG;
        this.TYPE = TYPE;
        this.ANTWOORD = ANTWOORD;
    }

    public String getVRAAG() {
        return VRAAG;
    }

    public String getTYPE() {
        return TYPE;
    }

    public String getANTWOORD() {
        return ANTWOORD;
    }

    public ArrayList<String> getFout() {
        return fout;
    }
}
