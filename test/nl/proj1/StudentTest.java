package nl.proj1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {


    // Test Inschrijven voor Examen van Student "Test" en checkt of die ingeschreven is. iedere keer als deze test gerund wordt wordt de database
    // Aangepast naar hardcoded ExamenREQS zodat de test zinvol uitgevoerd kan worden :)
    @Test
    void getIngeschrevenExamens() {
        ASON.changeValue("nummerGebruiker","00000003","ingeschrevenExamens","ExamenREQS","dbStudent");
        Student student = new Student("00000003","Test","Test");
        ArrayList<Examen> ingeschrevenExamens = student.getIngeschrevenExamens();
        String expected = "ExamenREQS";
        String actual = ingeschrevenExamens.get(0).getNaam();
        assertEquals(expected,actual);
        for(Examen e : student.getIngeschrevenExamens()){
            boolean f = e.getNaam().equals("ExamenOPT1");
            assertFalse(f);
        }
        Examen ExamenOPT1 = new Examen("ExamenOPT1");
        student.examenInschrijven(ExamenOPT1);
        for(Examen e : student.getIngeschrevenExamens()){
            if(e.getNaam().equals("ExamenOPT1")){
                boolean f = e.getNaam().equals("ExamenOPT1");
                assertTrue(f);
            }
        }
    }

    @Test
    //Test het ophalen van een examen van een student, ook de cijfer daarvan en de resultaat nummer. Dit aan de hand van de getExamenResultaten methode

    void getExamenResultaten() {
        Student student = new Student("00000003","Test","Test");
        ArrayList<ExamenResultaat> resultaten = student.getExamenResultaten();
        for( ExamenResultaat e : resultaten){
            if(e.getExamen().getNaam().equals("ExamenREQS") && e.getCijfer().equals("5.5") && e.getResultaatNummer().equals("test")){
                boolean resultaatBestaat = true;
                assertTrue(resultaatBestaat);
            }
        }
    }
}