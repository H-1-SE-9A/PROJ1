package nl.proj1;

import java.util.ArrayList;

public class Student extends User {

    private ArrayList<Examen> ingeschrevenExamens;
    private ArrayList<ExamenResultaat> examenResultaten;

    public Student(String nummerGebruiker, String naamVoor, String naamAchter) {
        super(nummerGebruiker, naamVoor, naamAchter);
        this.ingeschrevenExamens = initIngeschrevenExamens(nummerGebruiker);
        this.examenResultaten = initResultaten(nummerGebruiker);
    }

    private ArrayList<Examen> initIngeschrevenExamens(String nummerGebruiker) {
        ArrayList<Examen> ingeschrevenExamens = new ArrayList<>();
        ArrayList<String> opgehaaldeExamens = ASON.getArrayValue("nummerGebruiker", nummerGebruiker, "ingeschrevenExamens", "dbStudent");
        if(!opgehaaldeExamens.get(0).equals("")){
            for (String s : opgehaaldeExamens) {
                ingeschrevenExamens.add(new Examen(s));
            }
        }
        return ingeschrevenExamens;
    }

    private ArrayList<ExamenResultaat> initResultaten(String nummerGebruiker) {
        ArrayList<ExamenResultaat> examenResultaten = new ArrayList<>();
        ArrayList<String> opgehaaldeResultaten = ASON.getArrayValue("nummerGebruiker", nummerGebruiker, "resultaten", "dbStudent");
        if(!opgehaaldeResultaten.get(0).equals("")){
            for (String s : opgehaaldeResultaten) {
                examenResultaten.add(new ExamenResultaat(s));
            }
        }
        return examenResultaten;
    }

    public void examenInschrijven(Examen examen) {
        ASON.addArrayValue("nummerGebruiker",super.getNummerGebruiker(),"ingeschrevenExamens",examen.getNaam(),"dbStudent");
        ingeschrevenExamens.add(examen);

    }

    public void examenAfnemen(Examen examen) {
        Prompt.promptLine();
        System.out.println(Prompt.ANSI_GREEN + "Welkom bij het examen " + examen.getNaam() + Prompt.ANSI_RESET);
        String resultaat = examen.maakExamen();

        ArrayList<String> nummers = ASON.stripValue("resultaatNummer","dbExamenResultaten");
        int laatstePositie = nummers.size()-1;
        int nummer = Integer.parseInt(nummers.get(laatstePositie))+1;
        ASON.makeObject("resultaatNummer", String.valueOf(nummer),"nummerGebruiker",super.getNummerGebruiker(),"examen",examen.getNaam(),"resultaat",resultaat,"dbExamenResultaten");
        ASON.addArrayValue("nummerGebruiker",super.getNummerGebruiker(),"resultaten",String.valueOf(nummer),"dbStudent");
        this.examenResultaten = initResultaten(super.getNummerGebruiker());


        if(Double.parseDouble( resultaat.replace(",",".")) >= 5.5){
            System.out.println( "\u001b[32;1m" + "Gefeliciteerd! jij bent geslaagd voor " + examen.getNaam() +"!" + Prompt.ANSI_RESET);
            System.out.println("Jouw cijfer is: " + resultaat);
        }
        else{
            System.out.println( Prompt.ANSI_RED + "Helaas. jij bent niet geslaagd voor " + examen.getNaam() +"." + Prompt.ANSI_RESET);
            System.out.println("Jouw cijfer is: " + resultaat);
        }
    }

    public void examenResultaten(Examen examen) {
        int counter = 1;
        System.out.printf("Dit zijn de resultaten voor %24s:%n", examen.getNaam());
        System.out.printf("%24s%24s%n","Resultaat #", "Cijfer");
        for (ExamenResultaat er : examenResultaten) {
            if(er.getExamen().getNaam().equals(examen.getNaam())) {
                System.out.printf("%24d%24s%n", counter, er.getCijfer());
                counter++;
            }
        }
    }

    public ArrayList<Examen> getIngeschrevenExamens() {
        return ingeschrevenExamens;
    }

    public ArrayList<ExamenResultaat> getExamenResultaten() {
        return examenResultaten;
    }
}
