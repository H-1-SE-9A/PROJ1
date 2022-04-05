package nl.PROJ1.screens.admin;

import nl.PROJ1.ASON;
import nl.PROJ1.screens.other.Login;
import nl.PROJ1.Objects.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LijstIngeschrevenStudentPerExamen {
    public static ArrayList<String> examenLijsten = User.getAlleExamens();
    public static ArrayList<String> studenten = ASON.stripValue("Gebruikersnummer", "UserInformation");
    public static ArrayList<String> examens = ASON.stripValue("Examen", "UserInformation");
    public static ArrayList<String> voornaam = ASON.stripValue("Voornaam", "UserInformation");
    public static ArrayList<String> achternaam = ASON.stripValue("Achternaam", "UserInformation");
    public static ArrayList<String> resultaat = ASON.stripValue("Resultaat", "UserInformation");

    public static int ingeschrevenStudentPerExamen() {
        int counter = 1;
        for (int i = 0; i < examenLijsten.size(); i++) {
            System.out.println(counter + ") " + examenLijsten.get(i));
            counter++;
        }
        System.out.println("0) Return");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice != 0) {
            counter = 1;
            alleStuPerExa(examenLijsten.get(choice - 1));
            System.out.println("");
            for (int i = 0; i < examenLijsten.size(); i++) {
                System.out.println(counter + ") " + examenLijsten.get(i));
                counter++;
            }
            System.out.println("0) Return");
            choice = scanner.nextInt();
        }
        return 3;
    }
    public static void alleStuPerExa(String examen) {
        System.out.println("De volgende studenten zijn ingeschreven voor het volgende examen: " + examen);
        System.out.printf("%n%14s%20s%30s%40s%n", "Leerlingnummer", "Voornaam", "Achternaam", "Resultaat");
        int y = 0;
        for (int i = 0; i < examens.size(); i++) {
            if (examens.get(i).contains(examen)) {
                ArrayList<String> HuidigeRes = ASON.striptArray("Gebruikersnummer", studenten.get(i), "Resultaat", "UserInformation");
                //System.out.println(examens);
                //Deze loop werkt niet zoals het moet werken
                for (int j = 0; j < HuidigeRes.size(); j++) {
                    //System.out.printf("%14s%20s%30s%n", studenten.get(i), voornaam.get(i), achternaam.get(i));
                    String res = null;
                    if (HuidigeRes.get(j).contains(examen)) {
                        res = HuidigeRes.get(j);
                        System.out.printf("%14s%20s%30s%40s%n", studenten.get(i), voornaam.get(i), achternaam.get(i), res);
                        y++;
                    }
                }
            }
        }
        if(y == 0) {
            System.out.println("Er zijn geen studenten voor dit examen ingeschreven!");
        }
    }
}
