package nl.proj1;

import java.util.ArrayList;

public class Leraar extends User {

    private ArrayList<Student> overzichtStudenten;
    private ArrayList<Examen> overzichtExamens;

    public Leraar(String nummerGebruiker, String naamVoor, String naamAchter) {
        super(nummerGebruiker, naamVoor, naamAchter);
        this.overzichtStudenten = initOverzichtStudenten();
        this.overzichtExamens = initOverzichtExamens();
    }

    private ArrayList<Examen> initOverzichtExamens() {
        ArrayList<Examen> overzichtExamens = new ArrayList<>();
        ArrayList<String> examens = ASON.stripValue("examen", "dbOverzichtExamens");
        for (String s : examens) {
            overzichtExamens.add(new Examen(s));
        }
        return overzichtExamens;
    }

    private ArrayList<Student> initOverzichtStudenten() {
        ArrayList<Student> overzichtStudenten = new ArrayList<>();
        ArrayList<String> nummerGebruiker = ASON.stripValue("nummerGebruiker", "dbStudent");
        ArrayList<String> naamVoor = ASON.stripValue("naamVoor", "dbStudent");
        ArrayList<String> naamAchter = ASON.stripValue("naamAchter", "dbStudent");
        for (int i = 0; i < nummerGebruiker.size(); i++) {
            overzichtStudenten.add(new Student(nummerGebruiker.get(i), naamVoor.get(i), naamAchter.get(i)));
        }
        return overzichtStudenten;
    }

    public void ingeschrevenStudenten(Examen examen) {
        System.out.println("De volgende studenten zijn ingeschreven voor " + examen.getNaam() + ":");
        System.out.printf("%24s%24s%24s%n", "Voornaam", "Achternaam", "Gebruikersnummer");
        for (Student s : overzichtStudenten) {
            for (Examen e : s.getIngeschrevenExamens()) {
                if (e.getNaam().contains(examen.getNaam())) {
                    System.out.printf("%24s%24s%24s%n", s.getNaamVoor(), s.getNaamAchter(), s.getNummerGebruiker());
                }
            }
        }
    }

    public void ingeschrevenExamens(Student user) {
        System.out.println("Student " + user.getNaamVoor() + " " + user.getNaamAchter() + " (" + user.getNummerGebruiker() + ") is ingerschreven voor de volgende examens:");
        for (Examen s : user.getIngeschrevenExamens()) {
            System.out.println(s.getNaam());
        }
    }

    public void behaaldeResultaten(Student user) {
        System.out.println("Student " + user.getNaamVoor() + " " + user.getNaamAchter() + " (" + user.getNummerGebruiker() + ") heeft de volgende resultaten gehaald:");
        System.out.printf("%24s%24s%24s%n", "Resultaat Nummer", "Examen", "Cijfer");
        for (ExamenResultaat s : user.getExamenResultaten()) {
            System.out.printf("%24s%24s%24s%n", s.getResultaatNummer(), s.getExamen().getNaam(), s.getCijfer());
        }
    }

    public void scorebord(Examen examen) {
        ArrayList<Student> studenten = new ArrayList<>();
        ArrayList<ExamenResultaat> cijfers = new ArrayList<>();
        for (Student s : overzichtStudenten) {
            for (ExamenResultaat es : s.getExamenResultaten()) {
                if (es.getExamen().getNaam().equals(examen.getNaam())) {
                    if (cijfers.size() == 0) {
                        cijfers.add(es);
                        studenten.add(s);
                    } else {
                        int counter = cijfers.size();
                        for (int i = 0; i < counter; i++) {
                            if (Double.parseDouble(es.getCijfer()) >= Double.parseDouble(cijfers.get(i).getCijfer())) {
                                cijfers.add(i, es);
                                studenten.add(i, s);
                                break;
                            } else if (i == cijfers.size() - 1) {
                                cijfers.add(es);
                                studenten.add(s);
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.printf("%24s%24s%24s%24s%24s%n", "Voornaam", "Achternaam", "Gebruikersnummer", "Cijfer", "Resultaatnummer");
        for (int i = 0; i < studenten.size(); i++) {
            System.out.printf("%24s%24s%24s%24s%24s%n", studenten.get(i).getNaamVoor(), studenten.get(i).getNaamAchter(), studenten.get(i).getNummerGebruiker(), cijfers.get(i).getCijfer(), cijfers.get(i).getResultaatNummer());
        }
    }

    public ArrayList<Student> getOverzichtStudenten() {
        return overzichtStudenten;
    }

    public ArrayList<Examen> getOverzichtExamens() {
        return overzichtExamens;
    }
}
