package nl.PROJ1.Objects;

import nl.PROJ1.ASON;

import java.util.ArrayList;

public class User {
    private String gebruikersnummer;
    private String voornaam;
    private String achternaam;
    public static ArrayList<String> ingeschrevenExamens = new ArrayList<>();
    public static ArrayList<String> examenResultaten = new ArrayList<>();
    public static ArrayList<String> isStudentIngeschreven = new ArrayList<>();

    public User(String gebruikersnummer) {
        this.gebruikersnummer = gebruikersnummer;
        ArrayList<String> x;
        x = ASON.stripValue("Gebruikersnummer", "UserInformation");
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).equals(gebruikersnummer)) {
                x = ASON.stripValue("Voornaam", "Userinformation");
                voornaam = x.get(i);
                x = ASON.stripValue("Achternaam", "Userinformation");
                achternaam = x.get(i);
                ingeschrevenExamens = ASON.striptArray("Gebruikersnummer", gebruikersnummer, "Examen", "UserInformation");
                examenResultaten = ASON.striptArray("Gebruikersnummer", gebruikersnummer, "Resultaat", "UserInformation");

                x = ASON.stripValue("Ingeschreven1", "Userinformation");
                isStudentIngeschreven.add(x.get(i));
                x = ASON.stripValue("Ingeschreven2", "Userinformation");
                isStudentIngeschreven.add(x.get(i));
                x = ASON.stripValue("Ingeschreven3", "Userinformation");
                isStudentIngeschreven.add(x.get(i));
                x = ASON.stripValue("Ingeschreven4", "Userinformation");
                isStudentIngeschreven.add(x.get(i));
            }
        }
    }

    // Deze methode moet een arraylist returnen
    // Deze functie moet naar het scherm examenResultaten
    public static ArrayList<String> getResultaten() {
        return examenResultaten;
    }

    // returnt nu de examens uit Userinformation ("Examen1", "Examen2")
    public static ArrayList<String> getIngeschrevenExamens() {
        return ingeschrevenExamens;
    }

    public static ArrayList<String> getIsStudentIngeschreven() {
        return isStudentIngeschreven;
    }

    // returnt ArrayList alleExamens met alle examens uit database ExamenLijsten
    public static ArrayList<String> getAlleExamens() {
        ArrayList<String> alleExamens;
        alleExamens = ASON.stripValue("Examen", "Examenlijsten");
        return alleExamens;
    }

    public String getGebruikersnummer() {

        return gebruikersnummer;
    }
}