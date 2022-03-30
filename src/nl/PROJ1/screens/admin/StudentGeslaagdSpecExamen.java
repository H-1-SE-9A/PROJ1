package nl.PROJ1.screens.admin;

import nl.PROJ1.ASON;
import nl.PROJ1.Objects.User;
import nl.PROJ1.screens.other.Login;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGeslaagdSpecExamen {
    public static int startStudentGeslaagdSpecExamen() {

        ArrayList<String> getAlleexamens = User.getAlleExamens();

        System.out.println("Voer leerlingnummer in: ");
        Scanner scanner = new Scanner(System.in);
        int leerlingNummer = scanner.nextInt();

        System.out.println("Is de student geslaagd voor een examen");
        if(!ASON.getValue("Gebruikersnummer", String.valueOf(leerlingNummer), "Resultaat1", "UserInformation").equals("null")) {
            System.out.println("1)    Resulaten " + getAlleexamens.get(0));
        }
        if(!ASON.getValue("Gebruikersnummer", String.valueOf(leerlingNummer), "Resultaat2", "UserInformation").equals("null")) {
            System.out.println("2)    Resulaten " + getAlleexamens.get(1));
        }
        if(!ASON.getValue("Gebruikersnummer", String.valueOf(leerlingNummer), "Resultaat3", "UserInformation").equals("null")) {
            System.out.println("3)    Resulaten " + getAlleexamens.get(2));
        }
        if(!ASON.getValue("Gebruikersnummer", String.valueOf(leerlingNummer), "Resultaat4", "UserInformation").equals("null")) {
            System.out.println("4)    Resulaten " + getAlleexamens.get(3));
        }
        System.out.println("5)    Terug");
        System.out.println("6)    Log uit");
        System.out.println("0)    Exit");
        System.out.println("");
        System.out.println("Maak uw keuze: ");

        int choise = scanner.nextInt();


        switch (choise) {
            case 0 -> {
                return 0;
            }
            case 1 -> {
                if (ASON.getValue("Gebruikersnummer", String.valueOf(leerlingNummer), "Ingeschreven1", "UserInformation").equals("True")) {
                    System.out.println("Dit zijn de cijfers van " + String.valueOf(leerlingNummer) + " voor "+ getAlleexamens.get(0) +  ": " + (ASON.getValue("Gebruikersnummer",String.valueOf(leerlingNummer), "Resultaat1", "UserInformation" )));
                    return 12;
                }
                else {
                        System.out.println("Student is nog niet ingeschreven voor dit Examen!");
                        return 12;
                    }
                }
            case 2 -> {
                if (ASON.getValue("Gebruikersnummer", String.valueOf(leerlingNummer), "Ingeschreven2", "UserInformation").equals("True")) {
                    System.out.println("Dit zijn de cijfers van " + String.valueOf(leerlingNummer) + " voor "+ getAlleexamens.get(1) +  ": " + (ASON.getValue("Gebruikersnummer",String.valueOf(leerlingNummer), "Resultaat2", "UserInformation" )));
                    return 12;
                }
                else {
                    System.out.println("Student is nog niet ingeschreven voor dit Examen!");
                    return 12;
                }
            }
            case 3 -> {
                if (ASON.getValue("Gebruikersnummer", String.valueOf(leerlingNummer), "Ingeschreven3", "UserInformation").equals("True")) {
                    System.out.println("Dit zijn de cijfers van " + String.valueOf(leerlingNummer) + " voor "+ getAlleexamens.get(2) +  ": " + (ASON.getValue("Gebruikersnummer",String.valueOf(leerlingNummer), "Resultaat3", "UserInformation" )));
                    return 12;
                }
                else {
                    System.out.println("Student is nog niet ingeschreven voor dit Examen!");
                    return 12;
                }
            }

            case 4 ->{
                if (ASON.getValue("Gebruikersnummer", String.valueOf(leerlingNummer), "Ingeschreven4", "UserInformation").equals("True")) {
                    System.out.println("Dit zijn de cijfers van " + String.valueOf(leerlingNummer) +  " voor "+ getAlleexamens.get(3) +  ": " +(ASON.getValue("Gebruikersnummer",String.valueOf(leerlingNummer), "Resultaat4", "UserInformation" )));
                    return 12;
                }
                else {
                    System.out.println("Student is nog niet ingeschreven voor dit Examen!");
                    return 12;
                }
            }
            case 5 -> {
                return 3;
            }
            case 6 -> {
                return 1;
            }
            default -> System.out.println("Ongeldige keuze!");
        }

        return 3;
    }
}
