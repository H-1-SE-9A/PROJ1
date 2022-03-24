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
            case 4 -> screenResultaten();
//            case 5 -> screenVoortgang();
            case 6 -> screenInschrijven();
//            case 7 -> screenMakenToets();
            case 8 -> screenRegister();
            case 9 -> screenStart();
<<<<<<< HEAD
            case 10 -> screenIsStudentGeslaagd();
            case 11 -> screenGehaaldeExamens();
            case 12 -> screenScorebord();
        }
    }
=======
            case 10 -> screenAdminStudentInschrijven();
            case 11 -> examenAfnemen();
        }
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
>>>>>>> origin/karam

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

    private static void screenInschrijven() {
        screenNumber = ScreenExamenInschrijven.startScreenExamenInschrijven();
        Prompt.promptLine();
        checkScreen();
    }

<<<<<<< HEAD
    private static void screenRegister(){

    }
    private static void screenStart(){

    }
    private static void screenIsStudentGeslaagd(){
        screenNumber = AdminIsStudentGeslaagd.startIsStudentGeslaagd();
        Prompt.promptLine();
        checkScreen();
    }
    private static void screenGehaaldeExamens(){
        screenNumber = AdminGehaaldeExamens.gehaaldeExamens();
        Prompt.promptLine();
        checkScreen();
        
    }
    private static void screenScorebord(){
        screenNumber = AdminScoreBord.startSchermScorebord();
        Prompt.promptLine();
        checkScreen();
    }

=======
    private static void screenInschrijven() {
        screenNumber = ScreenExamenInschrijven.startScreenExamenInschrijven();
        Prompt.promptLine();
        checkScreen();
    }
    private static void screenResultaten() {
        screenNumber = ExamenResultaten.startExamenResultaten();
        Prompt.promptLine();
        checkScreen();
    }
>>>>>>> origin/karam
}