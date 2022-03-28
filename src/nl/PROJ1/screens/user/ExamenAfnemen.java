package nl.PROJ1.screens.user;

import nl.PROJ1.Objects.Examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ExamenAfnemen {
    private static String examenNaam = "ExamenScrum";

    public static void setExamenNaam(String naam) {
        examenNaam = naam;

    }

    private static boolean afgelopen = false;
    private static int counter = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static int punten = 0;

    public static int start() {
        System.out.println(" U bent begonnen met het examen " + examenNaam);
        Examen examen = new Examen(examenNaam);
        while (!afgelopen) {
            System.out.println("Vraag " + (counter + 1) + ":");
            System.out.println(examen.getVraag(counter));
            String type = examen.getType(counter);
            if (type.equals("boolean")) {
                System.out.print("Type Ja of Nee als antwoord :");
                String antwoord = scanner.nextLine();
                if (antwoord.equals(examen.getAntwoord(counter))) {
                    punten++;

                }
                counter++;
            } else if (type.equals("mc")) {
                int count = 1;

                ArrayList<String> antwoorden = new ArrayList<>();
                antwoorden.add(examen.getAntwoord(counter));
                antwoorden.add(examen.getFout(counter, 0));
                antwoorden.add(examen.getFout(counter, 1));
                antwoorden.add(examen.getFout(counter, 2));
                antwoorden.add(examen.getFout(counter, 3));
                Collections.shuffle(antwoorden);
                for (int i = 0; i < antwoorden.size(); i++) {
                    System.out.println(count + ") " + antwoorden.get(i));
                    count++;
                }
                System.out.print("Type nummer van de juiste antwoord in: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        if (antwoorden.get(0).equals(examen.getAntwoord(counter))) {
                            punten++;
                        }
                        break;
                    case 2:
                        if (antwoorden.get(1).equals(examen.getAntwoord(counter))) {
                            punten++;
                        }
                        break;
                    case 3:
                        if (antwoorden.get(2).equals(examen.getAntwoord(counter))) {
                            punten++;
                        }

                        break;
                    case 4:
                        if (antwoorden.get(3).equals(examen.getAntwoord(counter))) {
                            punten++;
                        }

                        break;
                    case 5:
                        if (antwoorden.get(4).equals(examen.getAntwoord(counter))) {
                            punten++;
                        }

                        break;


                }
            counter++;
            } else {
                System.out.print("Type je antwoord hier: ");
                String antwoord = scanner.nextLine();
                if (antwoord.equals(examen.getAntwoord(counter))){
                    punten++;
                }
                counter++;
            }
            if(counter == 10){
                System.out.println("je totale punten voor dit examen zijn: " + punten);
                System.out.println("Dit examen bestond uit: " + (counter) + " vragen");
                afgelopen = true;
            }

        }

        return 2;
    }


}
