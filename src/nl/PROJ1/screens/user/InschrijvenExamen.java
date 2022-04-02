package nl.PROJ1.screens.user;

import nl.PROJ1.ASON;
import nl.PROJ1.Objects.User;
import nl.PROJ1.screens.other.Login;

import java.util.ArrayList;
import java.util.Scanner;

public class InschrijvenExamen {

    static ArrayList<String> alleExamens = User.getAlleExamens();

    public static int startScreenInschrijven() {
        // NIEUWE METHODE STRIP ARRAY , HAALT EEN ARRAYLIST OF VALUES UIT DE DATABASE
        ArrayList<String> ingeschrevenExamens = ASON.striptArray("Gebruikersnummer", Login.user.getGebruikersnummer(), "Examen", "UserInformation");
        System.out.println("Inschrijven Examen");
        int counter = 1;
        for (int i = 0; i < ingeschrevenExamens.size(); i++) {
            //CHEKT OF ALLE EXAMENS BEVAT EEN EXAMEN WAARVOOR JE INGESCHREVEN BENT
            if (alleExamens.contains(ingeschrevenExamens.get(i))) {
                // ZOJA HAALT HEM WEG
                alleExamens.remove(ingeschrevenExamens.get(i));
            }
        }
        //HIERONDER WORDT DE OVERGEBELVEN KEUZES GEPRINT
        for (int i = 0; i < alleExamens.size(); i++) {
            System.out.println(counter + ") " + alleExamens.get(i));
            counter++;
        }
        System.out.println("Maak uw keuze: of type 0 for exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        for (int i = 0; i < counter; i++) {
            if ((choice - 1) == i) {
                //AAN DE HAND VAN DE GEMAAKTE KEUZE WORD JE HIERONDER INGESCHREVEN VOOR EEN EXAMEN :)
                ASON.changeValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Examen", ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Examen", "UserInformation") + " - " + alleExamens.get(i), "Userinformation");

                System.out.println("Je bent nu ingeschreven voor " + alleExamens.get(i));
            }
        }
        return 2;
    }

}