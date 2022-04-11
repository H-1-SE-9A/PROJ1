package nl.proj1;

public class VraagOpen extends Vraag{

    private String antwoord;

    public VraagOpen(String vraag, String antwoord) {
        super(vraag);
        this.antwoord = antwoord;
    }

    public String getAntwoord() {
        return antwoord;
    }
}
