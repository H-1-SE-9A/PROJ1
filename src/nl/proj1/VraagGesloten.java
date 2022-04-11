package nl.proj1;

public class VraagGesloten extends Vraag {
    private boolean antwoord;

    public VraagGesloten(String vraag, boolean antwoord) {
        super(vraag);
        this.antwoord = antwoord;
    }

    public boolean getAntwoord() {
        return antwoord;
    }
}
