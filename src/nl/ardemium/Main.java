package nl.ardemium;

import Navigation.Controller;
import Register.Register;
import initUser.Login;

public class Main {

    public static void main(String[] args) {
        Prompt.promptLogo();

        boolean run = true;
        User sessionUser;

        System.out.println("Welkom bij Quiz Master!\nMaak een keuze uit het onderstaande menu.");

        while(run){
            System.out.printf("1) %24s%n2) %24s%n0) %24s%n","Login","Register","Exit");
            String input = Prompt.askInput();
            if(input.equals("1")){
                sessionUser = Login.startLogin();
                if(sessionUser == null){
                    System.out.println("Inloggen afgebroken!");
                }
                else if(sessionUser.getClass() == Leraar.class){
                    new Controller(sessionUser, 2);
                    sessionUser = null;
                }
                else if(sessionUser.getClass() == Student.class){
                    new Controller(sessionUser, 1);
                    sessionUser = null;
                }
            }
            else if(input.equals("2")) {
                String r = Register.startRegister();
                if(r.equals("0")){
                    System.out.println("Registratie afgebroken!");
                }
                else if(r.equals("1")){
                    System.out.println("Registratie succesvol!");
                }

            } else if(input.equals("0")){
                System.out.println("Exit");
                run = false;
            }
            else if(input.equals("help")){
                Prompt.promptHelp();
            }
        }
    }
}
