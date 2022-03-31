package nl.PROJ1.screens.user;
import nl.PROJ1.ASON;
import java.util.ArrayList;

public class GetResultaten {
    public static ArrayList<String> alleIngeschrevenExamens = new ArrayList<>();
    public static ArrayList<String> AlleResultaten = new ArrayList<>();
    private static String gebruikerNummer;
    private static String[] Resultaten;
    private static String[] ingeschrevenExamens;

    public static String[] getIngeschrevenExamens() {
        return ingeschrevenExamens;
    }

    public static void setGebruikerNummer(String gebruikernummer) {
        gebruikerNummer = gebruikernummer;
        start();
    }

    public static void start(){
         ArrayList<String> x = new ArrayList<>();
        x = ASON.stripValue("Gebruikersnummer", "UserInformation");
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).equals(gebruikerNummer)) {
                x = ASON.stripValue("Examen", "Userinformation");
                ingeschrevenExamens = x.get(i).split(" - ");
                for(int j = 0; j < ingeschrevenExamens.length; j++){
                    alleIngeschrevenExamens.add(ingeschrevenExamens[j]);
                }
                x = ASON.stripValue("Resultaat","Userinformation");
                Resultaten = x.get(i).split(" - ");
                for(int j = 0; j < Resultaten.length; j++){
                    AlleResultaten.add(Resultaten[j]);
                }

            }
        }


    }
}
