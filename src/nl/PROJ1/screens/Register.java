package nl.PROJ1.screens;

import nl.PROJ1.ASON;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    private static Scanner scanner;
    private static String username = "";
    private static String usernameConfirm = "";
    private static String password = "";
    private static String passwordConfirm = "";
    public static int startRegister() {

        promptRegister();
        askUsername();
        askPassword();
        makeUser();
        if(!ASON.checkMatch("Username",username,"Password",password,"Admin","false","UsersDatabase")){
            System.out.println("Er is een fout opgetreden, probeer opnieuw");
            startRegister();
        }
        else{
            System.out.println("Gebruiker toegevoegd!");
            return 9;
        }
        return 9;
    }
    private static void promptRegister() {
        System.out.println("Welkom bij examen centrum Quiz Master!");
        System.out.println("U staat nu op het punt om een nieuwe account aan te maken [0 = Exit]");

    }
    private static void askUsername() {
        scanner = new Scanner(System.in);
        System.out.print("gebruikersnummer: ");
        username = scanner.nextLine();
        System.out.print("gebruikersnummer bevestiging: ");
        usernameConfirm = scanner.nextLine();
        if (!username.equals(usernameConfirm)){
            System.out.println("gebruikersnummer komen niet met elkaar overeen, probeer het opnieuw");
            askUsername();
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
    private static void makeUser(){
        ArrayList<String> gebruikernummers = ASON.stripValue("Username","UsersDatabase");
        int gebruikernummer = Integer.parseInt(gebruikernummers.get(gebruikernummers.size()-1)) + 1;
        ASON.makeObject("Username", String.valueOf(gebruikernummer),"Password",password,"Admin","false","UsersDatabase");
    }
}
