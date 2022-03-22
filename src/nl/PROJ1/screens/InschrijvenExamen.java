package nl.PROJ1.screens;

import nl.PROJ1.ASON;
import nl.PROJ1.Objects.User;

import java.util.ArrayList;
import java.util.Scanner;

public class InschrijvenExamen {

    static ArrayList<String> alleExamens = User.getAlleExamens();
    static ArrayList<String> ingeschrevenExamens = User.getIngeschrevenExamens();

    String examen1 = "ExamenScrum";
    String examen2 = "ExamenOPT1";
    String examen3 = "ExamenOPT2";
    String examen4 = "ExamenOPT3";

    public static int startScreenInschrijven() {
        System.out.println("1)    Inschrijven ExamenScrum\n2)    Inschrijven ExamenOPT1 2\n3)    Inschrijven ExamenOPT2 3\n4)    Inschrijven ExamenOPT3\n5)    Log uit \n0)    Exit\n\n Maak uw keuze: )");

        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();

        // Toevoegen aan UserInformation werkt, nu moet hij aan het juiste gebruikersnummer worden gekoppeld

        switch (choise) {
            case 0 -> {
                return 0;
            }
            case 1 -> {
                if (ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven1", "UserInformation").equals("True")) {
                    System.out.println("Je bent al ingeschreven voor dit examen!");
                    return 6;
                }
                else {
                    ASON.changeValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven1", "True", "Userinformation");
                }
            }
            case 2 -> {
                if (ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven2", "UserInformation").equals("True")) {
                    System.out.println("Je bent al ingeschreven voor dit examen!");
                    return 6;
                }
                else {
                    ASON.changeValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven2", "True", "Userinformation");
                }
            }
            case 3 -> {
                if (ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven3", "UserInformation").equals("True")) {
                    System.out.println("Je bent al ingeschreven voor dit examen!");
                    return 6;
                }
                else {
                    ASON.changeValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven3", "True", "Userinformation");
                }
            }

            case 4 -> {
                if (ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven4", "UserInformation").equals("True")) {
                    System.out.println("Je bent al ingeschreven voor dit examen!");
                    return 6;
                }
                else {
                    ASON.changeValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven4", "True", "Userinformation");
                }
            }
            case 5 -> {
                return 1;
            }
            default -> System.out.println("Ongeldige keuze!");
        }

            // Voor alle keuzes die worden gemaakt moet in een tekst file opgeslagen worden waarvoor de student zich inschrijft
            // Student kan nu in een ander scherm beginnen met het examen
            // Student kan zich maar 1 keer inschrijven voor een examen


        return 2;
    }

}