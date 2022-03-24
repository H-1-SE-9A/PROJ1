package nl.PROJ1.screens;
import java.util.Scanner;

public class AdminScreenResultaten {

    public static int startScreenResultaten(){

        System.out.println("1)  Is Student Geslaagd 1\n2)  Gehaalde Examens 2\n3)  Scorebord 3\n 4)  Terug 4\n  Exit\n\n Maak uw keuze: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice){
            case 0 -> {
                return 0;
            }
            case 1 -> {
                return 10;
            }
            case 2 -> {
                return 11;
            }
            case 3 -> {
                return 12;
            }
            case 4 -> {
                return 3;
            }
            default -> {System.out.println("Ongeldige keuze!");}

        }
        return 3;
    }


}
