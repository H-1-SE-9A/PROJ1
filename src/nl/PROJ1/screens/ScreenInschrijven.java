package nl.PROJ1.screens;

import java.util.Scanner;

public class ScreenInschrijven {

    public static int startScreenInschrijven() {
        System.out.println("1)    Inschrijven Examen 1\n2)   Inschrijven Examen 2\n3)    Inschrijven Examen 3\n4)    Inschrijven Examen 4\n 5) Log uit \n 0)    Exit\n\n Maak uw keuze: ");

        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();

            // Voor alle keuzes die worden gemaakt moet in een tekst file opgeslagen worden waarvoor de student zich inschrijft
            // Student kan nu in een ander scherm beginnen met het examen
            // Student kan zich maar 1 keer inschrijven voor een examen

        //inschrijvenExamen(int gebruikerNummer)

        return 2;
    }

}
