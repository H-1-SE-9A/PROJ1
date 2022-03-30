package nl.PROJ1.screens.admin;

import nl.PROJ1.ASON;
import nl.PROJ1.screens.other.Login;
import nl.PROJ1.Objects.User;
import java.util.ArrayList;
import java.util.Scanner;

public class LijstIngeschrevenStudentPerExamen {
    public static ArrayList<String> getAlleExamens = User.getAlleExamens();
    public static ArrayList<String> alleStudenten = new ArrayList<>();
    //public static ArrayList<String> alleIngeschrevenStudentenExamenScrum = new ArrayList<>();

    public static ArrayList<String> getAlleStudenten(){
        alleStudenten = ASON.stripValue("Gebruikersnummer", "UserInformation");
        return alleStudenten;
    }

    public static int lijstIngeschrevenStudentenPerExamen() {
        LijstIngeschrevenStudentPerExamen.getAlleStudenten();
        System.out.println("Voor welk examen wil je de lijst met ingeschreven studenten zien?");
        System.out.println("1)    " + getAlleExamens.get(0) +  "\n2)    " + getAlleExamens.get(1) +  "\n3)    " + getAlleExamens.get(2)  +  "\n4)    " + getAlleExamens.get(3) +  "\n5)    Terug\n6)    Log uit\n0)    Exit\n\n Maak uw keuze: ");
        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();
        switch (choise){
            case 0 -> {
                return 0;
            }
            case 1 -> {
                for(int x = 0; x < alleStudenten.size(); x++){
                    if(ASON.getValue("Gebruikersnummer", alleStudenten.get(x), "Ingeschreven1", "UserInformation").equals("True")){
                        System.out.println(alleStudenten.get(x) + " is ingeschreven voor het examen: " + getAlleExamens.get(0));
                    }
                }
                return 3;
            }
            case 2 -> {
                for(int x = 0; x < alleStudenten.size(); x++){
                    if(ASON.getValue("Gebruikersnummer", alleStudenten.get(x), "Ingeschreven2", "UserInformation").equals("True")){
                        System.out.println(alleStudenten.get(x) + " is ingeschreven voor het examen: " + getAlleExamens.get(1));
                    }
                }
                return 3;
            }
            case 3 -> {
                for(int x = 0; x < alleStudenten.size(); x++){
                    if(ASON.getValue("Gebruikersnummer", alleStudenten.get(x), "Ingeschreven3", "UserInformation").equals("True")){
                        System.out.println(alleStudenten.get(x) + " is ingeschreven voor het examen: " + getAlleExamens.get(2));
                    }
                }
                return 3;
            }
            case 4 -> {
                for(int x = 0; x < alleStudenten.size(); x++){
                    if(ASON.getValue("Gebruikersnummer", alleStudenten.get(x), "Ingeschreven4", "UserInformation").equals("True")){
                        System.out.println(alleStudenten.get(x) + " is ingeschreven voor het examen: " + getAlleExamens.get(3));
                    }
                }
                return 3;
            }
            case 5 -> {
                return 2;
            }
            case 6 -> {
                return 1;
            }
            default -> {System.out.println("Ongeldige keuze!");}
        }
        return 4;
    }
}
