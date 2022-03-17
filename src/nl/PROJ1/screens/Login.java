package nl.PROJ1.screens;

import nl.PROJ1.ASON;

import java.util.Objects;
import java.util.Scanner;

public class Login {
    private static Scanner scanner;
    private static String username = "";
    private static String password = "";

    public static int startLogin() {
        promptLogin();
        while (!ASON.checkMatch("Username", username, "Password", password, "UsersDatabase")) {
            askUsername();
            if(Objects.equals(username, "0")){return 0;}
            askPassword();
            if(Objects.equals(password, "0")){return 0;}
            if (!ASON.checkMatch("Username", username, "Password", password, "UsersDatabase")) {
                System.out.println("gebruikersnummer en/of wachtwoord fout");
            }
        }
        if (ASON.checkMatch("Username", username, "Password", password, "Admin", "true", "UsersDatabase")) {
            username = "";
            password = "";
            return 3;
        }
        username = "";
        password = "";
        return 2;
    }

    private static void promptLogin() {
        System.out.println("Welkom bij examen centrum A.S.O.N!");
        System.out.println("Login met uw gebruikersnummer en wachtwoord. [0 = Exit]");

    }

    private static void askUsername() {
        scanner = new Scanner(System.in);
        System.out.println("gebruikersnummer: ");
        username = scanner.nextLine();
    }

    private static void askPassword() {
        scanner = new Scanner(System.in);
        System.out.println("wachtwoord: ");
        password = scanner.nextLine();
    }
}