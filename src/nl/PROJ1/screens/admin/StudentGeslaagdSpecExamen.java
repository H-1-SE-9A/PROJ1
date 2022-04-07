package nl.PROJ1.screens.admin;

import nl.PROJ1.ASON;
import nl.PROJ1.Objects.User;
import nl.PROJ1.screens.other.Login;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGeslaagdSpecExamen {

    static int choice;

    public static int startStudentGeslaagdSpecExamen() {

        ArrayList<String> ingeschrevenExamens = User.getIngeschrevenExamens();
        ArrayList<String> examenResultaten = User.getResultaten();
        ArrayList<String> gemaaktExamens = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer leerlingnummer in: ");
        int leerlingNummer = scanner.nextInt();

        int counter = 1;

        for (int i = 0; i < ingeschrevenExamens.size(); i++) {
            String str = ingeschrevenExamens.get(i);
            for (int j = 0; j < examenResultaten.size(); j++) {
                if (examenResultaten.get(j).contains(str)) {
                    if (!gemaaktExamens.contains(str)) {
                        gemaaktExamens.add(str);
                    }
                }
            }
        }
        int thirdcounter = 0;


        int secondCounter = 0;
        boolean goodchoice = false;
        while (!goodchoice) {
            Scanner s = new Scanner(System.in);
            thirdcounter = counter;
            secondCounter = 0;
            for (int i = 0; i < gemaaktExamens.size(); i++) {

                System.out.println(thirdcounter + ")    " + gemaaktExamens.get(i));
                thirdcounter++;
                secondCounter++;
            }

            System.out.println(thirdcounter + ")    Alle resultaten");
            thirdcounter++;
            System.out.println(thirdcounter + ")    Terug");
            thirdcounter++;
            System.out.println(thirdcounter + ")    Log uit");
            thirdcounter++;
            System.out.println("0)    Exit");
            System.out.println("");
            System.out.println("Maak uw keuze: ");

            if (s.hasNextInt()) {
                choice = Integer.parseInt(s.next());
                for (int i = 0; i < secondCounter; i++) {

                    if ((choice - 1) == i && choice < secondCounter) {

                        goodchoice = true;
                        String str = gemaaktExamens.get(i);
                        for (int j = 0; j < examenResultaten.size(); j++) {
                            if (examenResultaten.get(j).startsWith(str)) {
                                System.out.println(ASON.striptResultaat(examenResultaten.get(j)));
                                int parseInt1 = Integer.parseInt(ASON.striptResultaat(examenResultaten.get(j)));
                                if (parseInt1 >= 5.5) {
                                    System.out.println((ASON.getValue("Gebruikersnummer", String.valueOf(leerlingNummer), "Voornaam", "UserInformation")) + " " + (ASON.getValue("Gebruikersnummer", String.valueOf(leerlingNummer), "Achternaam", "UserInformation")) + " is geslaagd voor dit examen!");

                                }
                            }

                        }
                    } else if (choice == secondCounter + 1) {
                        goodchoice = true;

                        for (int j = 0; j < gemaaktExamens.size(); j++) {
                            for (int l = 0; l < examenResultaten.size(); l++) {
                                String str = gemaaktExamens.get(j);
                                if (examenResultaten.get(l).contains(str)) {
                                    System.out.println("voor (" + str + ") heeft de leerling " + ASON.striptResultaat(examenResultaten.get(l)) + " gescoord");
                                }
                            }
                        }


                    } else if (choice == (secondCounter + 2)) {
                        goodchoice = true;

                        return 3;
                    } else if (choice == (secondCounter + 3)) {
                        goodchoice = true;
                        return 1;
                    } else if (choice == 0) {
                        goodchoice = true;
                        return 0;

                    }
                }
            }
            else {
                System.out.println("Ongeldige keuze!");
            }
        }
        return 3;
    }

}

