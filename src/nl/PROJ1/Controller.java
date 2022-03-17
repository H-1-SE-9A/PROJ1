package nl.PROJ1;

import nl.PROJ1.screens.*;

public class Controller {

    private static int screenNumber = 1;

    public static void start() {
        Prompt.promptLine();
        Prompt.promptLogo();
        checkScreen();
    }

    private static void checkScreen() {

        switch (screenNumber) {
            case 0 -> System.out.println("Exit");
            case 1 -> screenLogin();
            case 2 -> screenUserPortal();
            case 3 -> screenAdminPortal();
//            case 4 -> screenResultaten();
//            case 5 -> screenVoortgang();
//            case 6 -> screenInschrijven();
//            case 7 -> screenMakenToets();
        }
    }

    private static void screenLogin() {
        screenNumber = Login.startLogin();
        Prompt.promptLine();
        checkScreen();
    }

    private static void screenUserPortal() {
        screenNumber = UserPortal.startUserPortal();
        Prompt.promptLine();
        checkScreen();
    }

    private static void screenAdminPortal() {
        screenNumber = AdminPortal.startAdminPortal();
        Prompt.promptLine();
        checkScreen();
    }
}