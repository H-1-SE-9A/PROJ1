package nl.PROJ1.screens.user;

import nl.PROJ1.ASON;
import nl.PROJ1.Objects.User;
import nl.PROJ1.screens.other.Login;

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

        System.out.println("Inschrijven Examen");
        if(ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven1", "UserInformation").equals("False")) {
            System.out.println("1)    Inschrijven ExamenScrum");
        }
        if(ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven2", "UserInformation").equals("False")) {
            System.out.println("2)    Inschrijven ExamenOPT1");
        }
        if(ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven3", "UserInformation").equals("False")) {
            System.out.println("3)    Inschrijven ExamenOPT2");
        }
        if(ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven4", "UserInformation").equals("False")) {
            System.out.println("4)    Inschrijven ExamenOPT3");
        }
        System.out.println("5)    Terug");
        System.out.println("6)    Log uit");
        System.out.println("0)    Exit");
        System.out.println("");
        System.out.println("Maak uw keuze: ");

        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();


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
                    System.out.println("Je bent nu ingeschreven voor dit examen!");
                    return 6;
                }
            }
            case 2 -> {
                if (ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven2", "UserInformation").equals("True")) {
                    System.out.println("Je bent al ingeschreven voor dit examen!");
                    return 6;
                }
                else {
                    ASON.changeValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven2", "True", "Userinformation");
                    System.out.println("Je bent nu ingeschreven voor dit examen!");
                    return 6;
                }
            }
            case 3 -> {
                if (ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven3", "UserInformation").equals("True")) {
                    System.out.println("Je bent al ingeschreven voor dit examen!");
                    return 6;
                }
                else {
                    ASON.changeValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven3", "True", "Userinformation");
                    System.out.println("Je bent nu ingeschreven voor dit examen!");
                    return 6;
                }
            }

            case 4 -> {
                if (ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven4", "UserInformation").equals("True")) {
                    System.out.println("Je bent al ingeschreven voor dit examen!");
                    return 6;
                }
                else {
                    ASON.changeValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven4", "True", "Userinformation");
                    System.out.println("Je bent nu ingeschreven voor dit examen!");
                    return 6;
                }
            }
            case 5 -> {
                return 2;
            }
            case 6 -> {
                return 1;
            }
            default -> System.out.println("Ongeldige keuze!");
        }

        return 2;
    }

}