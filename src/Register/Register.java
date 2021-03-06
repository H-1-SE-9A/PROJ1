package Register;

import nl.proj1.ASON;
import nl.proj1.Prompt;

import java.util.ArrayList;

public class Register {

    public static String startRegister(){

        boolean pending = true;
        String voornaam;
        String achternaam;
        String wachtwoord;
        String wachtwoordHerhaling;

        while(pending) {
            Prompt.promptLine();
            System.out.println(Prompt.ANSI_GREEN +"Welkom bij het registratie portaal. Volg de ondestaande stappen om een account aan te maken." + Prompt.ANSI_RESET);
            System.out.println("Wat is uw voornaam?");
            System.out.print("Voornaam: ");
            voornaam = Prompt.askInput();
            if (voornaam.equals("0")) {
                return "0";
            }
            System.out.println("Wat is uw achternaam?");
            System.out.print("Achternaam: ");
            achternaam = Prompt.askInput();
            if (achternaam.equals("0")) {
                return "0";
            }
            System.out.println("Maak nu een nieuwe wachtwoord aan");
            System.out.print("Wachtwoord: ");
            wachtwoord = Prompt.askInput();
            if (wachtwoord.equals("0")) {
                return "0";
            }

            System.out.println("Bevestig uw nieuwe wachtwoord: ");
            System.out.print("Bevestig Wachtwoord: ");
            wachtwoordHerhaling = Prompt.askInput();
            if (wachtwoordHerhaling.equals("0")) {
                return "0";
            }
            if(wachtwoord.equals(wachtwoordHerhaling)){
                System.out.println("Kloppen de volgende gegevens?");
                System.out.println("Voornaam: " + voornaam);
                System.out.println("Achternaam: " + achternaam);
                System.out.println("[Y/N]");
                String bevestiging = Prompt.askInput();
                if(bevestiging.equalsIgnoreCase("y")){
                    ArrayList<String> nummers = ASON.stripValue("nummerGebruiker","dbStudent");
                    int laatstePositie = nummers.size()-1;
                    int nummer = Integer.parseInt(nummers.get(laatstePositie))+1;
                    System.out.println("Uw gebruikersnummer is (" + String.format("%08d",nummer) + ") dit nummer word gebruikt om in te loggen.");
                    System.out.println("Schrijf dit nummer goed op!");
                    System.out.println("Type het nummer over om te bevestigen. [0 = Stop Registreren]");
                    boolean overtypen = true;
                    while(overtypen){
                        String input = Prompt.askInput();
                        if(input.equals(String.format("%08d", nummer))){
                            overtypen = false;
                        }
                        else if(input.equals("0")){
                            return "0";
                        }
                        else{
                            System.out.println("Nummer komt niet overeen");
                        }
                    }
                    ASON.makeObject("nummerGebruiker", String.format("%08d", nummer),"naamVoor",voornaam,"naamAchter",achternaam,"ingeschrevenExamens","","resultaten","","dbStudent");
                    ASON.makeObject("nummerGebruiker", String.format("%08d", nummer),"wachtwoord",wachtwoord,"leraar","false","dbLogin");
                    return "1";
                }
            }
            else {
                System.out.println("Wachtwoord komt niet overeen! Voer uw gegevens opnieuw in.");
            }
        }
        return "0";
    }
}
