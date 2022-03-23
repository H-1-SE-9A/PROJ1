package nl.PROJ1.screens;

import java.util.Scanner;

public class AdminPortal {
    public static int startAdminPortal() {
        System.out.println("1)    Resultaten\n2)    Voortgang\n3)    Student Inschrijven\n4)    Loguit\n0)    Exit\n Maak uw keuze: ");
        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();

        switch (choise) {
            case 0 -> {
                return 0;
            }
            case 1 -> {
                return 4;
            }
            case 2 -> {
                return 5;
            }
            case 3 -> {
                return 10;
            }
            case 4 -> {
                return 1;
            }
            default -> System.out.println("Ongeldige keuze!");

        }
        return 2;
    }
}
