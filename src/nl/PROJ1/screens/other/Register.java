package nl.PROJ1.screens.other;

import nl.PROJ1.ASON;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    private static Scanner scanner;
    private static String voornaam = "";
    private static String achternaam = "";
    private static String password = "";
    private static String passwordConfirm = "";
    private static ArrayList<String> gebruikernummers = ASON.stripValue("Username","UsersDatabase");
    private static int gebruikernummer = Integer.parseInt(gebruikernummers.get(gebruikernummers.size()-1)) + 1;
    public static int startRegister() {
        promptRegister();
        askName();
        if (!voornaam.equals("0")) {
            askPassword();
            makeUser();
            if (!ASON.checkMatch("Username", String.valueOf(gebruikernummer), "Password", password, "Admin", "false", "UsersDatabase")) {
                System.out.println("Er is een fout opgetreden, probeer opnieuw");
                startRegister();
            } else {
                System.out.println("Gebruiker toegevoegd!");
                return 9;
            }
            return 9;
        }
        else {

            return 9;
        }
    }

    private static void makeUser() {
        if(!ASON.checkMatch("Voornaam",voornaam,"Achternaam",achternaam,"UserInformation")) {
            ASON.makeObject("Gebruikernummer", String.valueOf(gebruikernummer), "Voornaam", voornaam, "Achternaam", achternaam,"Examen1","ExamenScrum","Ingeschreven1","False","Resultaat1", "null","Examen2","ExamenOPT1","Ingeschreven2","False","Resultaat2","null","Examen3","ExamenOPT2","Ingeschreven3","False","Examen4","ExamenOPT3","Ingeschreven4","False","Resultaat4","null", "UserInformation");
            ASON.makeObject("Username", String.valueOf(gebruikernummer), "Password", password, "Admin", "false", "UsersDatabase");
        }
        else{
            System.out.println("gebruiker bestaat al, probeer een andere");
            startRegister();
        }

    }

    private static void askPassword() {
        scanner = new Scanner(System.in);
        System.out.print("wachtwoord: ");
        password = scanner.nextLine();
        System.out.print("wachtwoord bevestiging: ");
        passwordConfirm = scanner.nextLine();

        if (!password.equals(passwordConfirm)){
            System.out.println("wachtwoord komen niet met elkaar overeen, probeer het opnieuw");
            askPassword();
        }
    }

    private static void askName() {
        scanner = new Scanner(System.in);
        System.out.print("Vul hier voornaam van student in: ");
        voornaam = scanner.nextLine();
        if (!voornaam.equals("0")){
            System.out.print("Vul hier achternaam van student in: ");
            achternaam = scanner.nextLine();
        }

    }



    private static void promptRegister() {

        System.out.println("U staat nu op het punt om een nieuwe student in te schrijven [0 = terug]");
    }
}