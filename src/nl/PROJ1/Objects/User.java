package nl.PROJ1.Objects;

import nl.PROJ1.ASON;

import java.util.ArrayList;

public class User {
    private String gebruikersnummer;
    private String voornaam;
    private String achternaam;
    ArrayList<String> examenlijst = new ArrayList<>();
    ArrayList<String> examenResultaten = new ArrayList<>();
    ArrayList<String> ingeschrevenExamens = new ArrayList<>();

    public User(String gebruikersnummer) {
        this.gebruikersnummer = gebruikersnummer;
        ArrayList<String> x = new ArrayList<>();
        x = ASON.stripValue("Gebruikersnummer", "UserInformation");
        //System.out.println(x.get(1));
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).equals(gebruikersnummer)) {
                x = ASON.stripValue("Voornaam", "Userinformation");
                voornaam = x.get(i);
                x = ASON.stripValue("Achternaam", "Userinformation");
                achternaam = x.get(i);
                x = ASON.stripValue("Examen1", "Userinformation");
                examenlijst.add(x.get(i));
                x = ASON.stripValue("Examen2", "Userinformation");
                examenlijst.add(x.get(i));
                x = ASON.stripValue("Resultaat1", "Userinformation");
                examenResultaten.add(x.get(i));
                x = ASON.stripValue("Resultaat2", "Userinformation");
                examenResultaten.add(x.get(i));
                //System.out.println(voornaam + " " + achternaam);
                //System.out.println(examenlijst);
                //System.out.println(examenResultaten);
            }
        }
    }
}