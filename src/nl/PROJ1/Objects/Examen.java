package nl.PROJ1.Objects;

import nl.PROJ1.ASON;

import java.util.ArrayList;

public class Examen{
    private final ArrayList<Vraag> examen;
    private final String database;

    public Examen(String database) {
        this.database = database;
        examen = initVragenLijst();
    }

    private ArrayList<Vraag> initVragenLijst(){
        ArrayList<Vraag> examenInit = new ArrayList<>();
        ArrayList<String> vraag = ASON.stripValue("Vraag",database);
        ArrayList<String> type = ASON.stripValue("Type",database);
        ArrayList<String> antwoord = ASON.stripValue("Antwoord",database);
        ArrayList<String> fout1 = ASON.stripValue("Fout1",database);
        ArrayList<String> fout2 = ASON.stripValue("Fout2",database);
        ArrayList<String> fout3 = ASON.stripValue("Fout3",database);
        ArrayList<String> fout4 = ASON.stripValue("Fout4",database);
        int x = 0;
        for(int i = 0; i < vraag.size();i++){
            if(!type.get(i).equals("mc")){
                Vraag v = new Vraag(vraag.get(i), type.get(i), antwoord.get(i));
                examenInit.add(v);
            }
            else{
                ArrayList<String> foutAntwoorden = new ArrayList<>();
                foutAntwoorden.add(fout1.get(x));
                foutAntwoorden.add(fout2.get(x));
                foutAntwoorden.add(fout3.get(x));
                foutAntwoorden.add(fout4.get(x));
                Vraag v = new Vraag(vraag.get(i), type.get(i), antwoord.get(i),foutAntwoorden);
                examenInit.add(v);
                x++;
            }
        }
        return examenInit;
    }

    public String getVraag(int nummer){
        return examen.get(nummer).getVRAAG();
    }

    public String getType(int nummer){
        return examen.get(nummer).getTYPE();
    }

    public String getAntwoord(int nummer){
        return examen.get(nummer).getANTWOORD();
    }

    public String getFout(int nummer, int foutNummer){
        return examen.get(nummer).getFout().get(foutNummer);
    }
}
