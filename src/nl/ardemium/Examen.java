package nl.ardemium;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import static java.lang.Math.round;

public class Examen {

    private String naam;
    private ArrayList<Vraag> alleVragen = new ArrayList<>();

    public Examen(String naam) {
        this.naam = naam;

        for (VraagGesloten v : initGesloten(naam)) {
            alleVragen.add(v);
        }
        for (VraagOpen v : initOpen(naam)) {
            alleVragen.add(v);
        }
        for (VraagMeerkeuzen v : initMeerkeuzen(naam)) {
            alleVragen.add(v);
        }

    }

    private ArrayList<VraagGesloten> initGesloten(String naam) {
        ArrayList<VraagGesloten> vraagGesloten = new ArrayList<>();
        ArrayList<String> vraag = ASON.stripValue("Vraag", "db" + naam);
        ArrayList<String> type = ASON.stripValue("Type", "db" + naam);
        ArrayList<String> antwoord = ASON.stripValue("Antwoord", "db" + naam);
        for (int i = 0; i < vraag.size(); i++) {
            if (type.get(i).equals("gesloten")) {
                if (antwoord.get(i).equals("true")) {
                    vraagGesloten.add(new VraagGesloten(vraag.get(i), true));
                } else {
                    vraagGesloten.add(new VraagGesloten(vraag.get(i), false));
                }
            }
        }
        return vraagGesloten;
    }

    private ArrayList<VraagOpen> initOpen(String naam) {
        ArrayList<VraagOpen> vraagOpen = new ArrayList<>();
        ArrayList<String> vraag = ASON.stripValue("Vraag", "db" + naam);
        ArrayList<String> type = ASON.stripValue("Type", "db" + naam);
        ArrayList<String> antwoord = ASON.stripValue("Antwoord", "db" + naam);
        for (int i = 0; i < vraag.size(); i++) {
            if (type.get(i).equals("open")) {
                vraagOpen.add(new VraagOpen(vraag.get(i), antwoord.get(i)));
            }
        }

        return vraagOpen;
    }

    private ArrayList<VraagMeerkeuzen> initMeerkeuzen(String naam) {
        ArrayList<VraagMeerkeuzen> vraagMeerkeuzen = new ArrayList<>();
        ArrayList<String> vraag = ASON.stripValue("Vraag", "db" + naam);
        ArrayList<String> type = ASON.stripValue("Type", "db" + naam);
        ArrayList<String> antwoord = ASON.stripValue("Antwoord", "db" + naam);
        ArrayList<String> temp = ASON.stripValue("Fout", "db" + naam);
        ArrayList<ArrayList<String>> fout = new ArrayList<>();
        for (String s : temp) {
            ArrayList<String> object = new ArrayList<>();
            String[] tempstring = s.split("-");
            for (String ts : tempstring) {
                object.add(ts);
            }
            fout.add(object);
        }
        int counter = 0;
        for (int i = 0; i < vraag.size(); i++) {
            if (type.get(i).equals("meerkeuze")) {
                vraagMeerkeuzen.add(new VraagMeerkeuzen(vraag.get(i), antwoord.get(i), fout.get(counter)));
                counter++;
            }
        }
        return vraagMeerkeuzen;
    }

    public String getNaam() {
        return naam;
    }

    private ArrayList<Vraag> schudExamen() {
        int aantalVragen = alleVragen.size();
        ArrayList<Vraag> tempCopyExamen = (ArrayList<Vraag>) alleVragen.clone();
        ArrayList<Vraag> copyExamen = new ArrayList<>();

        Random r = new Random();
        for (Vraag v : alleVragen) {
            int i = r.nextInt(aantalVragen);
            copyExamen.add(tempCopyExamen.get(i));
            tempCopyExamen.remove(i);
            aantalVragen--;
        }
        return copyExamen;
    }

    public String maakExamen() {
        ArrayList<Vraag> examen = schudExamen();
        int goedBeantwoord = 0;
        for (Vraag v : examen) {
            if (v.getClass() == VraagMeerkeuzen.class) {
                Random r = new Random();
                System.out.printf("%n%s%n", v.getVraag());
                int randomInterfal = r.nextInt(((VraagMeerkeuzen) v).getAntwoordFouten().size());
                for (int i = 0; i < ((VraagMeerkeuzen) v).getAntwoordFouten().size() + 1; i++) {
                    if (i == randomInterfal) {
                        System.out.printf("%d) %s%n", i, ((VraagMeerkeuzen) v).getAntwoord());
                    } else if (i > randomInterfal) {
                        System.out.printf("%d) %s%n", i, ((VraagMeerkeuzen) v).getAntwoordFouten().get(i - 1));
                    } else {
                        System.out.printf("%d) %s%n", i, ((VraagMeerkeuzen) v).getAntwoordFouten().get(i));
                    }
                }
                System.out.printf("(0- %d) ", ((VraagMeerkeuzen) v).getAntwoordFouten().size());
                if (!Prompt.askInput().equals(String.valueOf(randomInterfal))) {
                    System.out.printf("%nFout! Het goede antwoord was: %n%s%n", ((VraagMeerkeuzen) v).getAntwoord());
                } else {
                    System.out.println("Goed!");
                    goedBeantwoord++;
                }

            } else if (v.getClass() == VraagOpen.class) {
                System.out.printf("%n%s%n", v.getVraag());
                String s = Prompt.askInput();
                if (s.equalsIgnoreCase(((VraagOpen) v).getAntwoord()) || s.contains(((VraagOpen) v).getAntwoord().toLowerCase(Locale.ROOT)) || s.contains(((VraagOpen) v).getAntwoord())) {
                    System.out.println("Goed!");
                    goedBeantwoord++;
                } else {
                    System.out.printf("%nFout! Het goede antwoord was: %n%s%n", ((VraagOpen) v).getAntwoord());
                }
            } else if (v.getClass() == VraagGesloten.class) {
                System.out.printf("%n%s%n", v.getVraag());
                String s = Prompt.askInput();
                if (((VraagGesloten) v).getAntwoord() == true && ((s.equalsIgnoreCase("ja") || s.equalsIgnoreCase("j") || s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes")))) {
                    System.out.println("Goed!");
                    goedBeantwoord++;
                } else if (((VraagGesloten) v).getAntwoord() == false && ((s.equalsIgnoreCase("nee") || s.equalsIgnoreCase("n") || s.equalsIgnoreCase("no")) || (s.contains("nee") || s.contains("no")))) {
                    System.out.println("Goed!");
                    goedBeantwoord++;
                } else {
                    System.out.printf("%nFout! Het goede antwoord was: %n%s%n", ((VraagGesloten) v).getAntwoord());
                }
            }
        }

        double n = Double.parseDouble(ASON.getValue("examen",naam,"nNorm","dbOverzichtExamens"));

        return String.format("%.1f",9.0* (double) goedBeantwoord / (double) examen.size() + n);


    }
}
