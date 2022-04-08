package initUser;

import nl.ardemium.*;

public class Login {

    public static User startLogin() {
        String gebruikersnummer = "";
        String wachtwoord = "";
        boolean pending = true;

        while (pending) {
            System.out.println("Voer uw gebruikersnummer in:");
            gebruikersnummer = Prompt.askInput();
            if (gebruikersnummer.equals("0")) {
                return null;
            }
            System.out.println("Voer uw wachtwoord in:");
            wachtwoord = Prompt.askInput();
            if (wachtwoord.equals("0")) {
                return null;
            }

            if (wachtwoord.equals(ASON.getValue("nummerGebruiker", gebruikersnummer, wachtwoord, "dbLogin")) && ASON.getValue("nummerGebruiker", gebruikersnummer, "leraar", "dbLogin").equals("true")) {
                return new Leraar("Admin", "Admin", "Admin");
            } else if (wachtwoord.equals(ASON.getValue("nummerGebruiker", gebruikersnummer, wachtwoord, "dbLogin"))) {
                return new Student(gebruikersnummer, ASON.getValue("nummerGebruiker", gebruikersnummer, "naamVoor", "dbStudent"), ASON.getValue("nummerGebruiker", gebruikersnummer, "naamAchter", "dbStudent"));
            }
        }
        return null;
    }

}
