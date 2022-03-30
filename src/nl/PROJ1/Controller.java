package nl.PROJ1;

import nl.PROJ1.screens.admin.AdminPortal;
import nl.PROJ1.screens.admin.AdminStudentInschrijven;
import nl.PROJ1.screens.admin.StudentGeslaagdSpecExamen;
import nl.PROJ1.screens.other.Login;
import nl.PROJ1.screens.other.Prompt;
import nl.PROJ1.screens.other.Register;
import nl.PROJ1.screens.other.Start;
import nl.PROJ1.screens.user.ExamenAfnemen;
import nl.PROJ1.screens.user.ExamenResultaten;
import nl.PROJ1.screens.user.InschrijvenExamen;
import nl.PROJ1.screens.user.UserPortal;

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
            case 4 -> screenResultaten();
//            case 5 -> screenVoortgang();
            case 6 -> screenExamenInschrijven();
//            case 7 -> screenMakenToets();
            case 8 -> screenRegister();
            case 9 -> screenStart();
            case 10 -> screenAdminStudentInschrijven();
            case 11 -> examenAfnemen();
            case 12 -> StudentGeslaagdSpecExamen();
        }
    }

    private static void StudentGeslaagdSpecExamen() {
        screenNumber = StudentGeslaagdSpecExamen.startStudentGeslaagdSpecExamen();
        Prompt.promptLine();
        checkScreen();
    }

    private static void examenAfnemen() {
        screenNumber = ExamenAfnemen.start();
        Prompt.promptLine();
        checkScreen();
    }

    private static void screenAdminStudentInschrijven() {
        screenNumber = AdminStudentInschrijven.start();
        Prompt.promptLine();
        checkScreen();
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
        screenNumber = InschrijvenExamen.startScreenInschrijven();
        Prompt.promptLine();
        checkScreen();
    }

    private static void screenInschrijven() {
        screenNumber = InschrijvenExamen.startScreenInschrijven();
        Prompt.promptLine();
        checkScreen();
    }
    private static void screenResultaten() {
        screenNumber = ExamenResultaten.startExamenResultaten();
        Prompt.promptLine();
        checkScreen();
    }
}