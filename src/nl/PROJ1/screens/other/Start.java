package nl.PROJ1.screens.other;

import java.util.Scanner;

public class Start {
    static int choice = 99999;

    public static int startScreen() {

        boolean goodchoice = false;
        while (!goodchoice) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Maak hieronder een keuze");
            System.out.println("1- Inloggen");
            System.out.println("2- Registreren");
            System.out.print("Type hier je keuze in of type 0 voor Exit: ");


            if (scanner.hasNextInt()) {
                choice = Integer.parseInt(scanner.next());

                switch (choice) {
                    case 0 -> {
                        goodchoice = true;
                        choice = 0;
                    }
                    case 1 -> {
                        goodchoice = true;
                        choice = 1;
                    }
                    case 2 -> {
                        goodchoice = true;
                        choice = 8;
                    }

                }
            } else {
                System.out.println("ongeldige keuze");

            }

        }
            return choice;

    }}