package nl.PROJ1.screens.user;
import nl.PROJ1.ASON;
import nl.PROJ1.Objects.User;
import nl.PROJ1.screens.other.Login;

import java.util.ArrayList;
import java.util.Scanner;

public class ExamenResultaten {
    public static ArrayList<String> ingeschrevenExamens = User.getIngeschrevenExamens();
    public static ArrayList<String> examenResultaten = User.getResultaten();
    public static ArrayList<String> isStudentIngeschreven = User.getIsStudentIngeschreven();

    public ExamenResultaten(ArrayList<String> ingeschrevenExamens, ArrayList<String> examenResultaten, ArrayList<String> isStudentIngeschreven){
        this.ingeschrevenExamens = ingeschrevenExamens;
        this.examenResultaten = examenResultaten;
        this.isStudentIngeschreven = isStudentIngeschreven;
    }
    public static int startExamenResultaten() {
        //System.out.println("1)    " + ingeschrevenExamens.get(0) +  "\n2)    " + ingeschrevenExamens.get(1) +  "\n3)    " + ingeschrevenExamens.get(2) +  "\n4)    " + ingeschrevenExamens.get(3) +  "\n5)    Logout\n0)    Exit\n\n Maak uw keuze: ");
        System.out.println("Inschrijven Examen");
        if(ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven1", "UserInformation").equals("True")) {
            System.out.println("1)    " + ingeschrevenExamens.get(0) +  "");
        }
        if(ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven2", "UserInformation").equals("True")) {
            System.out.println("2)    " + ingeschrevenExamens.get(1) +  "");
        }
        if(ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven3", "UserInformation").equals("True")) {
            System.out.println("3)    " + ingeschrevenExamens.get(2) +  "");
        }
        if(ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven4", "UserInformation").equals("True")) {
            System.out.println("4)    " + ingeschrevenExamens.get(3) +  "");
        }
        System.out.println("5)    Terug");
        System.out.println("6)    Log uit");
        System.out.println("0)    Exit");
        System.out.println("");
        System.out.println("Maak uw keuze: ");

        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();
        switch (choise){
            case 0 -> {
                return 0;
            }
            case 1 -> {
                System.out.println("Resultaat " + ingeschrevenExamens.get(0) + ": " + examenResultaten.get(0) + "\n");
                return 4;
            }
            case 2 -> {
                System.out.println("Resultaat " + ingeschrevenExamens.get(1) + ": " + examenResultaten.get(1) + "\n");
                return 4;
            }
            case 3 -> {
                System.out.println("Resultaat " + ingeschrevenExamens.get(2) + ": " + examenResultaten.get(2) + "\n");
                return 4;
            }
            case 4 -> {
                System.out.println("Resultaat " + ingeschrevenExamens.get(2) + ": " + examenResultaten.get(3) + "\n");
                return 4;
            }
            case 5 -> {
                return 2;
            }
            case 6 -> {
                return 1;
            }
            default -> {System.out.println("Ongeldige keuze!");}
            }
            return 4;
        }

    public void showResultaten() {
        int count = 0;
        for (String naam : ingeschrevenExamens) {
            System.out.println(naam + " " + examenResultaten.get(count));
            count++;
        }
    }
}