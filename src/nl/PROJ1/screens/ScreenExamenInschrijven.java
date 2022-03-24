package nl.PROJ1.screens;

import nl.PROJ1.ASON;
import nl.PROJ1.Objects.Examen;
import nl.PROJ1.Objects.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ScreenExamenInschrijven {

    static ArrayList<String> alleExamens = User.getAlleExamens();
    static ArrayList<String> ingeschrevenExamens = User.getIngeschrevenExamens();

    String examen1 = "ExamenScrum";
    String examen2 = "ExamenOPT1";
    String examen3 = "ExamenOPT2";
    String examen4 = "ExamenOPT3";

    public static int startScreenExamenInschrijven() {
        System.out.println("1)    Inschrijven ExamenScrum\n2)    Inschrijven ExamenOPT1 2\n3)    Inschrijven ExamenOPT2 3\n4)    Inschrijven ExamenOPT3\n5)    Log uit \n0)    Exit\n\n Maak uw keuze: )");

        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();

        // Toevoegen aan UserInformation werkt, nu moet hij aan het juiste gebruikersnummer worden gekoppeld

        switch (choise) {
            case 0 -> {
                return 0;
            }
            case 1 -> {
                if (ASON.checkMatch("Examen1", "ExamenScrum", "Resultaat1", "Null", "UserInformation")) {
                    System.out.println("Je bent al ingeschreven voor dit examen!");
                }
                else {
                    ASON.makeObject("Examen1", "ExamenScrum", "Resultaat1", "Null", "Userinformation");
                }
            }
            case 2 -> {
                if (ASON.checkMatch("Examen2", "ExamenOPT1", "Resultaat2", "Null", "UserInformation")) {
                    System.out.println("Je bent al ingeschreven voor dit examen!");
                }
                else {
                    ASON.makeObject("Examen2", "ExamenOPT1", "Resultaat2", "Null", "Userinformation");
                }
            }
            case 3 -> {
                if (ASON.checkMatch("Examen3", "ExamenOPT2", "Resultaat3", "Null", "UserInformation")) {
                    System.out.println("Je bent al ingeschreven voor dit examen!");
                }
                else {
                    ASON.makeObject("Examen3", "ExamenOPT2", "Resultaat3", "Null", "Userinformation");
                }
            }

            case 4 -> {
                if (ASON.checkMatch("Examen4", "ExamenOPT3", "Resultaat4", "Null", "UserInformation")) {
                    System.out.println("Je bent al ingeschreven voor dit examen!");
                }
                else {
                    ASON.makeObject("Examen4", "ExamenOPT3", "Resultaat4", "Null", "Userinformation");
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