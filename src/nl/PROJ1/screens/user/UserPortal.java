package nl.PROJ1.screens.user;

import java.util.Scanner;

public class UserPortal {

    public static int startUserPortal() {
        System.out.println("1)    Resultaten\n2)    Voortgang\n3)    Inschrijven\n4)    Examen Afnemen\n5)    Loguit\n0)    Exit\n\n Maak uw keuze: ");
        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();

        switch (choise){
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
                return 6;
            }
            case 4 -> {
                return 11;
            }
            case 5 -> {
                return 1;
            }

            default -> {System.out.println("Ongeldige keuze!");}

        }
        return 2;
    }


}
