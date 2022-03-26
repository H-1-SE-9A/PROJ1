package nl.PROJ1.screens;
import java.util.Scanner;
import nl.PROJ1.ASON;
import java.util.ArrayList;
import nl.PROJ1.Objects.User;

public class ScreenExamenKiezen {
    public static ArrayList<String> ingeschrevenExamens = User.getIngeschrevenExamens();
    public static ArrayList<String> examenResultaten = User.getResultaten();
    public static ArrayList<String> isStudentIngeschreven = User.getIsStudentIngeschreven();
    public static ArrayList<String> alleExamens = User.getAlleExamens();

    public ScreenExamenKiezen(ArrayList<String> ingeschrevenExamens, ArrayList<String> examenResultaten, ArrayList<String> isStudentIngeschreven){
        this.ingeschrevenExamens = ingeschrevenExamens;
        this.examenResultaten = examenResultaten;
        this.isStudentIngeschreven = isStudentIngeschreven;
    }
    public static int startExamenKiezen() {
        System.out.println("Examen Kiezen");
        if(ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven1", "UserInformation").equals("True")) {
            System.out.println("1)    " + ingeschrevenExamens.get(0) +  "");
        }
        if(ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven2", "UserInformation").equals("True")) {
            System.out.println("2)    " + ingeschrevenExamens.get(1) +  "");
        }
        if(ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven3", "UserInformation").equals("True")) {
            System.out.println("3)    " + ingeschrevenExamens.get(2) +  "");
        }
        if(ASON.getValue("Gebruikersnummer", Login.user.getGebruikersnummer(), "Ingeschreven4", "UserInformation").equals("True")) {
            System.out.println("4)    " + ingeschrevenExamens.get(3) +  "");
        }
        System.out.println("5)    Terug");
        System.out.println("6)    Log uit");
        System.out.println("0)    Exit");
        System.out.println("");
        System.out.println("Maak uw keuze: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 0 -> {
                return 0;
            }
            case 1 -> {
                ExamenAfnemen.setExamenNaam(ingeschrevenExamens.get(0));
                return 11;
            }
            case 2 -> {
                ExamenAfnemen.setExamenNaam(ingeschrevenExamens.get(1));
                return 11;
            }
            case 3 -> {
                ExamenAfnemen.setExamenNaam(ingeschrevenExamens.get(2));
                return 11;
            }
            case 4 -> {
                ExamenAfnemen.setExamenNaam(ingeschrevenExamens.get(3));
                return 11;
            }
            case 5 -> {
                return 2;
            }
            case 6 -> {
                return 1;
            }
            default -> {System.out.println("Ongeldige keuze!");}
        }
        return 12;
        }
}