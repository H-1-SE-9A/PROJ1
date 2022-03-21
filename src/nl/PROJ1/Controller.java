package nl.PROJ1;

import nl.PROJ1.screens.*;

import java.util.Scanner;

public class Controller {

    private static int screenNumber = 9;

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
            case 6 -> screenExamenInschrijven();
//            case 7 -> screenMakenToets();
            case 8 -> screenRegister();
            case 9 -> screenStart();
        }
    }
    private static void screenStart(){
        screenNumber = Start.startScreen();
        Prompt.promptLine();
        checkScreen();

    }
    private static void screenRegister() {
        screenNumber = Register.startRegister();
        Prompt.promptLine();
        checkScreen();
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

    private static void screenExamenInschrijven() {
        screenNumber = ScreenExamenInschrijven.startScreenExamenInschrijven();
        Prompt.promptLine();
        checkScreen();
    }
}