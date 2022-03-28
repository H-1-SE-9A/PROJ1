package nl.PROJ1.screens.user;
import nl.PROJ1.Objects.User;

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
        System.out.println("1)    " + ingeschrevenExamens.get(0) +  "\n2)    " + ingeschrevenExamens.get(1) +  "\n3)    " + ingeschrevenExamens.get(2) +  "\n4)    " + ingeschrevenExamens.get(3) +  "\n5)    Logout\n0)    Exit\n\n Maak uw keuze: ");
        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();
        switch (choise){
            case 0 -> {
                return 0;
            }
            case 1 -> {
                System.out.println("Resultaat Examenscrum: " + examenResultaten.get(0));
                return 2;
            }
            case 2 -> {
                System.out.println("Resultaat ExamenOPT1: " + examenResultaten.get(1));
                return 2;
            }
            case 3 -> {
                System.out.println("Resultaat ExamenOPT2: " + examenResultaten.get(2));
                return 2;
            }
            case 4 -> {
                System.out.println("Resultaat ExamenOPT3: " + examenResultaten.get(3));
                return 2;
            }
            case 5 -> {
                return 1;
            }
            default -> {System.out.println("Ongeldige keuze!");}
            }
            return 2;
        }

    public void showResultaten() {
        int count = 0;
        for (String naam : ingeschrevenExamens) {
            System.out.println(naam + " " + examenResultaten.get(count));
            count++;
        }
    }
}