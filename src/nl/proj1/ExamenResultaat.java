package nl.proj1;

public class ExamenResultaat {

    private  String resultaatNummer;
    private Examen examen;
    private String resultaat;

    public ExamenResultaat(String resultaatNummer) {
        this.resultaatNummer = resultaatNummer;
        resultaat = initResultaat();
        this.examen = initExamen();
    }

    private String initResultaat() {
        return ASON.getValue("resultaatNummer",resultaatNummer,"resultaat", "dbExamenResultaten");
    }

    private Examen initExamen() {
        return new Examen(ASON.getValue("resultaatNummer",resultaatNummer,"examen", "dbExamenResultaten"));
    }

    public String getResultaatNummer() {
        return resultaatNummer;
    }

    public Examen getExamen() {
        return examen;
    }

    public String getCijfer() {
        return resultaat;
    }
}
