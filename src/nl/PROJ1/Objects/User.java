package nl.PROJ1.Objects;

import nl.PROJ1.ASON;

import java.util.ArrayList;

public class User {
    private String gebruikersnummer;
    private String voornaam;
    private String achternaam;
<<<<<<< HEAD
    public ArrayList<String> ingeschrevenExamens = new ArrayList<>();
    public ArrayList<String> examenResultaten = new ArrayList<>();
=======
    public static ArrayList<String> ingeschrevenExamens = new ArrayList<>();
    public static ArrayList<String> examenResultaten = new ArrayList<>();
    public static ArrayList<String> isStudentIngeschreven = new ArrayList<>();
>>>>>>> origin/karam

    public User(String gebruikersnummer) {
        this.gebruikersnummer = gebruikersnummer;
        ArrayList<String> x;
        x = ASON.stripValue("Gebruikersnummer", "UserInformation");
<<<<<<< HEAD
        //System.out.println(x.get(1));
        for(int i = 0; i < x.size(); i++){
            if (x.get(i).equals(gebruikersnummer)){
=======
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).equals(gebruikersnummer)) {
>>>>>>> origin/karam
                x = ASON.stripValue("Voornaam", "Userinformation");
                voornaam = x.get(i);
                x = ASON.stripValue("Achternaam", "Userinformation");
                achternaam = x.get(i);
                x = ASON.stripValue("Examen1", "Userinformation");
                ingeschrevenExamens.add(x.get(i));
                x = ASON.stripValue("Examen2", "Userinformation");
                ingeschrevenExamens.add(x.get(i));
                x = ASON.stripValue("Examen3", "Userinformation");
                ingeschrevenExamens.add(x.get(i));
                x = ASON.stripValue("Examen4", "Userinformation");
                ingeschrevenExamens.add(x.get(i));
                x = ASON.stripValue("Resultaat1", "Userinformation");
                examenResultaten.add(x.get(i));
                x = ASON.stripValue("Resultaat2", "Userinformation");
                examenResultaten.add(x.get(i));
                x = ASON.stripValue("Resultaat3", "Userinformation");
                examenResultaten.add(x.get(i));
                x = ASON.stripValue("Resultaat4", "Userinformation");
                examenResultaten.add(x.get(i));
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
    public static ArrayList<String> getIngeschrevenExamens(){
        return ingeschrevenExamens;
    }

    public static ArrayList<String> getIsStudentIngeschreven(){
        return isStudentIngeschreven;
    }

    // returnt ArrayList alleExamens met alle examens uit database ExamenLijsten
    public static ArrayList<String>getAlleExamens(){
        ArrayList<String> alleExamens;
        alleExamens = ASON.stripValue("Examen", "Examenlijsten");
        return alleExamens;
    }
    public String getGebruikersnummer(){
        return gebruikersnummer;
    }
}
