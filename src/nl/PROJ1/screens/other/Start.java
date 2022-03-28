package nl.PROJ1.screens.other;

import java.util.Scanner;

public class Start {

    public static int startScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Maak hieronder een keuze");
        System.out.println("1- Inloggen");
        System.out.println("2- Registreren");
        System.out.print("Type hier je keuze in of type 0 voor Exit: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 0 -> {
                choice = 0;
            }
            case 1 -> {
                choice = 1;
            }
            case 2 -> {
                choice = 8;
            }

        }
        return choice;
    }
}