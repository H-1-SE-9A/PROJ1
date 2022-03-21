package nl.PROJ1.Objects;

import nl.PROJ1.ASON;

import java.util.ArrayList;

public class User {
    private String gebruikersnummer;
    private String voornaam;
    private String achternaam;
    public static ArrayList<String> ingeschrevenExamens = new ArrayList<>();
    public ArrayList<String> examenResultaten = new ArrayList<>();

    public User(String gebruikersnummer) {
        this.gebruikersnummer = gebruikersnummer;
        ArrayList<String> x;
        x = ASON.stripValue("Gebruikersnummer", "UserInformation");
        //System.out.println(x.get(1));
        for(int i = 0; i < x.size(); i++){
            if (x.get(i).equals(gebruikersnummer)){
                x = ASON.stripValue("Voornaam", "Userinformation");
                voornaam = x.get(i);
                x = ASON.stripValue("Achternaam", "Userinformation");
                achternaam = x.get(i);
                x = ASON.stripValue("Examen1", "Userinformation");
                ingeschrevenExamens.add(x.get(i));
                x = ASON.stripValue("Examen2", "Userinformation");
                ingeschrevenExamens.add(x.get(i));
                x = ASON.stripValue("Resultaat1", "Userinformation");
                examenResultaten.add(x.get(i));
                x = ASON.stripValue("Resultaat2", "Userinformation");
                examenResultaten.add(x.get(i));
            }
        }
    }
    // Deze methode moet een arraylist returnen
    // Deze functie moet naar het scherm examenResultaten
    public ArrayList<String> getResultaten() {
        return examenResultaten;
        //int count = 0;
        //for (String naam : ingeschrevenExamens) {
            //System.out.println(naam + " " + examenResultaten.get(count));
            //count++;
    }
    // returnt nu de examens uit Userinformation ("Examen1", "Examen2")
    public static ArrayList<String> getIngeschrevenExamens(){
        return ingeschrevenExamens;
    }
    // returnt ArrayList alleExamens met alle examens uit database ExamenLijsten
    public static ArrayList<String>getAlleExamens(){
        ArrayList<String> alleExamens;
        alleExamens = ASON.stripValue("Examen", "Examenlijsten");
        return alleExamens;
    }
}
